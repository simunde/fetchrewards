package com.msid.fetchrewards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msid.fetchrewards.api.ListItemApi
import com.msid.fetchrewards.api.RetrofitHelper
import com.msid.fetchrewards.model.Items
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {

    private val _items = MutableLiveData<Items>()
    val items: LiveData<Items> = _items

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        fetchData()
    }


    private fun fetchData() {
        viewModelScope.launch {
            val result = RetrofitHelper.getInstance().create(ListItemApi::class.java).getItems()
            if (result.isSuccessful) {
                val response = result.body()

                // Ensure response is not null
                response?.let { items ->
                    // Filter out items where name is null or blank
                    val filteredItems = items.filter { !it.name.isNullOrBlank() }

                    // Group items by listId and sort them
                    val groupedAndSortedItems = filteredItems
                        .sortedWith(compareBy({ it.listId }, { it.name }))

                    // Convert the sorted list to an Items object (Items is ArrayList<ListItem>)
                    val itemsObject = Items().apply { addAll(groupedAndSortedItems) }

                    // Update LiveData
                    _items.value = itemsObject
                }
            } else {
                // Handle API error
                val errorMessage = "Error ${result.code()}: ${result.message()}"
                _error.value = errorMessage            }
        }
    }


}