package com.recyclingmap.recyclingmap.ui.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.recyclingmap.recyclingmap.R
import com.recyclingmap.recyclingmap.data.model.RecyclingCenter

class RecyclingCenterAdapter(private val onItemClick: (RecyclingCenter) -> Unit) :
    ListAdapter<RecyclingCenter, RecyclingCenterAdapter.ViewHolder>(RecyclingCenterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_recycling_center_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        private val recyclableMaterialsTextView: TextView = itemView.findViewById(R.id.materialsTextView)
        private val latTextView: TextView = itemView.findViewById(R.id.latTextView)
        private val lngTextView: TextView = itemView.findViewById(R.id.lngTextView)

        fun bind(recyclingCenter: RecyclingCenter) {
            nameTextView.text = recyclingCenter.name
            locationTextView.text = recyclingCenter.address
            latTextView.text = recyclingCenter.latitude
            lngTextView.text = recyclingCenter.longitude
            recyclableMaterialsTextView.text =
                "Materiais aceitos: " + recyclingCenter.recyclable_materials.joinToString(", ") { it.name }

            itemView.setOnClickListener {
                onItemClick(recyclingCenter)
            }
        }
    }

    class RecyclingCenterDiffCallback : DiffUtil.ItemCallback<RecyclingCenter>() {
        override fun areItemsTheSame(oldItem: RecyclingCenter, newItem: RecyclingCenter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecyclingCenter, newItem: RecyclingCenter): Boolean {
            return oldItem == newItem
        }
    }
}