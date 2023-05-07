// Este pacote contém a classe RecyclingCenterViewModel, responsável por gerenciar
// os dados dos centros de reciclagem e comunicar-se com a camada de dados remotos.
package com.recyclingmap.recyclingmap.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.recyclingmap.recyclingmap.data.model.RecyclingCenter
import com.recyclingmap.recyclingmap.data.remote.RetrofitClient
import kotlinx.coroutines.launch

// A classe RecyclingCenterViewModel é uma subclasse de ViewModel e é responsável por
// gerenciar os dados dos centros de reciclagem e comunicar-se com a camada de dados remotos.
class RecyclingCenterViewModel : ViewModel() {
    // Declaração da variável MutableLiveData para armazenar a lista de centros de reciclagem.
    val recyclingCenters = MutableLiveData<List<RecyclingCenter>>()

    // Bloco init é executado quando a classe é instanciada.
    init {
        // Busca a lista de centros de reciclagem.
        fetchRecyclingCenters()
    }

    // Função privada para buscar a lista de centros de reciclagem usando Retrofit.
    private fun fetchRecyclingCenters() {
        // Usa viewModelScope para executar a função de forma assíncrona.
        viewModelScope.launch {
            // Faz a chamada para a API usando Retrofit e armazena a resposta.
            val response = RetrofitClient.instance.getRecyclingCenters()
            // Atualiza o valor da variável MutableLiveData com a lista de centros de reciclagem.
            recyclingCenters.value = response
        }
    }
}
