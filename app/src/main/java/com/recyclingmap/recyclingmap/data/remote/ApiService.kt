// Este pacote contém a API de serviço remoto usada para obter dados do servidor.
package com.recyclingmap.recyclingmap.data.remote

import com.recyclingmap.recyclingmap.data.model.RecyclingCenter
import retrofit2.http.GET

// A interface ApiService define os pontos finais da API e as funções correspondentes que são usadas
// para interagir com o servidor e obter dados, neste caso, os centros de reciclagem.
interface ApiService {
    // A anotação @GET define o tipo de requisição HTTP (neste caso, uma requisição GET)
    // e a URL do ponto final da API relativo à URL base.
    @GET("recycling_centers")
    // A função getRecyclingCenters() é uma função suspensa do Kotlin, o que significa que ela pode ser chamada
    // dentro de uma coroutine sem bloquear a thread em que está sendo executada.
    // Essa função retorna uma lista de objetos RecyclingCenter.
    suspend fun getRecyclingCenters(): List<RecyclingCenter>
}
