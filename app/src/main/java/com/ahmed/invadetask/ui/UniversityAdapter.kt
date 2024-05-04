package com.ahmed.invadetask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.invadetask.databinding.ItemUniversityBinding
import com.ahmed.invadetask.model.University

class UniversityAdapter(
    private val onItemClick: (University) -> Unit
) : ListAdapter<University, UniversityAdapter.UniversityViewHolder>(UniversityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding =
            ItemUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

    }

    inner class UniversityViewHolder(private val binding: ItemUniversityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(university: University) {
            binding.universityName.text = university.name
            binding.state.text = university.stateProvince
        }
    }

    private class UniversityDiffCallback : DiffUtil.ItemCallback<University>() {
        override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem == newItem
        }
    }
}
