// Este pacote contém a classe RecyclingCenterAdapter, responsável por exibir
// os itens da lista de centros de reciclagem no RecyclerView.
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

// A classe RecyclingCenterAdapter é uma subclasse de ListAdapter e é responsável por
// exibir os itens da lista de centros de reciclagem no RecyclerView.
class RecyclingCenterAdapter(private val onItemClick: (RecyclingCenter) -> Unit) :
    ListAdapter<RecyclingCenter, RecyclingCenterAdapter.ViewHolder>(RecyclingCenterDiffCallback()) {

    // Cria um novo ViewHolder para exibir os itens da lista.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_recycling_center_item, parent, false)
        return ViewHolder(itemView)
    }

    // Vincula os dados do centro de reciclagem ao ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    // A classe ViewHolder é uma subclasse de RecyclerView.ViewHolder e é responsável
    // por exibir os dados de um centro de reciclagem no RecyclerView.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declaração das Views no item do RecyclerView.
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        private val recyclableMaterialsTextView: TextView = itemView.findViewById(R.id.materialsTextView)
        private val latTextView: TextView = itemView.findViewById(R.id.latTextView)
        private val lngTextView: TextView = itemView.findViewById(R.id.lngTextView)

        // A função bind vincula os dados do centro de reciclagem às Views do ViewHolder.
        fun bind(recyclingCenter: RecyclingCenter) {
            nameTextView.text = recyclingCenter.name
            locationTextView.text = recyclingCenter.address
            latTextView.text = recyclingCenter.latitude
            lngTextView.text = recyclingCenter.longitude
            recyclableMaterialsTextView.text =
                "Materiais aceitos: " + recyclingCenter.recyclable_materials.joinToString(", ") { it.name }

            // Configura o listener de clique para o item do RecyclerView.
            itemView.setOnClickListener {
                onItemClick(recyclingCenter)
            }
        }
    }

    // A classe RecyclingCenterDiffCallback é uma subclasse de DiffUtil.ItemCallback e é
    // responsável por calcular a diferença entre duas listas de centros de reciclagem.
    class RecyclingCenterDiffCallback : DiffUtil.ItemCallback<RecyclingCenter>() {
        // Compara se os itens são os mesmos, usando seus IDs.
        override fun areItemsTheSame(oldItem: RecyclingCenter, newItem: RecyclingCenter): Boolean {
            return oldItem.id == newItem.id
        }

        // Compara se os conteúdos dos itens são os mesmos.
        override fun areContentsTheSame(oldItem: RecyclingCenter, newItem: RecyclingCenter): Boolean {
            return oldItem == newItem
        }
    }
}