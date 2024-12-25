package com.msid.fetchrewards.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.msid.fetchrewards.databinding.ActivityMainBinding
import com.msid.fetchrewards.model.ListItemAdapter
import com.msid.fetchrewards.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ListItemAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        viewModel.items.observe(this){
                item->
            adapter= ListItemAdapter(item)
            binding.recyclerView.adapter=adapter
            binding.recyclerView.layoutManager= LinearLayoutManager(this)
        }
    }
}