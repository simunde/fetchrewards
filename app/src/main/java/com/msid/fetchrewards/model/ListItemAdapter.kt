package com.msid.fetchrewards.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.msid.fetchrewards.R

class ListItemAdapter(private val items: List<ListItem>): RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>() {

    class ListItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        private val textViewListID: TextView = itemView.findViewById(R.id.textViewListID)

        fun bind(item: ListItem) {
            textViewId.text = item.id.toString()
            textViewListID.text = item.listId.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
}