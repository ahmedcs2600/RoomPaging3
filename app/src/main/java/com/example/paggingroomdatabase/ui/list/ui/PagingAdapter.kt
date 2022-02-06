package com.example.paggingroomdatabase.ui.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paggingroomdatabase.databinding.NoteItemBinding
import com.example.paggingroomdatabase.entity.NoteItem

class PagingAdapter : PagingDataAdapter<NoteItem, PagingAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(private val binding : NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item : NoteItem) {
            binding.title.text = item.name
            binding.description.text = item.description
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NoteItem>() {
        override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = getItem(position) ?: return
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}