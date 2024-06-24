package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private val feedItems = mutableListOf<FeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feedItems[position])
    }

    override fun getItemCount(): Int = feedItems.size

    fun submitList(items: List<FeedItem>) {
        feedItems.clear()
        feedItems.addAll(items)
        notifyDataSetChanged()
    }

    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(feedItem: FeedItem) {
            titleTextView.text = feedItem.title
            descriptionTextView.text = feedItem.description
        }
    }
}
