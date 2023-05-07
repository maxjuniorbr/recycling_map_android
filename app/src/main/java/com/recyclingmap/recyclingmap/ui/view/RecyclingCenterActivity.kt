// Este pacote contém a classe RecyclingCenterActivity que exibe a lista de centros de reciclagem.
package com.recyclingmap.recyclingmap.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclingmap.recyclingmap.R
import com.recyclingmap.recyclingmap.ui.viewmodel.RecyclingCenterAdapter
import com.recyclingmap.recyclingmap.ui.viewmodel.RecyclingCenterViewModel

// A classe RecyclingCenterActivity é uma subclasse de AppCompatActivity e é responsável por
// exibir a lista de centros de reciclagem.
class RecyclingCenterActivity : AppCompatActivity() {

    // Declaração de uma variável lateinit para o ViewModel.
    private lateinit var viewModel: RecyclingCenterViewModel

    // A função onCreate é chamada quando a Activity é criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout XML para a Activity.
        setContentView(R.layout.activity_recycling_center)

        // Inicializa o ViewModel.
        viewModel = ViewModelProvider(this).get(RecyclingCenterViewModel::class.java)

        // Cria o adaptador do RecyclerView.
        val adapter = RecyclingCenterAdapter { recyclingCenter ->
            // Cria o Uri para o centro de reciclagem selecionado.
            val gmmIntentUri =
                Uri.parse("geo:${recyclingCenter.latitude},${recyclingCenter.longitude}?q=${recyclingCenter.latitude},${recyclingCenter.longitude}(${recyclingCenter.name})")
            // Cria um Intent para abrir o aplicativo de mapas com a localização do centro de reciclagem.
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            // Inicia a Activity do aplicativo de mapas.
            startActivity(mapIntent)
        }

        // Configura o RecyclerView.
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Observa as mudanças na lista de centros de reciclagem e atualiza o adaptador.
        viewModel.recyclingCenters.observe(this, Observer { centers ->
            adapter.submitList(centers)
        })
    }
}