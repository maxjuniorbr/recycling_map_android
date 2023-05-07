// Este pacote contém a classe de cliente remoto Retrofit usada para configurar e criar
// a instância da API de serviço.
package com.recyclingmap.recyclingmap.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// A classe RetrofitClient é um objeto único (singleton) que gerencia a configuração
// e a criação do cliente Retrofit.
object RetrofitClient {
    // A URL base para todas as requisições da API.
    private const val BASE_URL = "https://run.mocky.io/v3/6db2bdd3-ca7f-4845-9388-ac0f0b6d028a/"

    // Cria um cliente OkHttpClient que pode ser usado para personalizar as solicitações.
    private val client = OkHttpClient.Builder().build()

    // A instância 'instance' é uma propriedade lazy (preguiçosa) que cria uma única instância
    // do ApiService. Como é lazy, só será inicializada quando for usada pela primeira vez.
    val instance: ApiService by lazy {
        // Cria e configura um objeto Retrofit.Builder, que é usado para construir a instância
        // do Retrofit.
        val retrofit = Retrofit.Builder()
            // Define a URL base para as solicitações da API.
            .baseUrl(BASE_URL)
            // Adiciona o GsonConverterFactory para converter automaticamente as respostas JSON
            // em objetos Kotlin.
            .addConverterFactory(GsonConverterFactory.create())
            // Define o cliente OkHttpClient que será usado para as solicitações.
            .client(client)
            // Constroi a instância do Retrofit.
            .build()

        // Cria a instância do ApiService a partir da instância do Retrofit.
        retrofit.create(ApiService::class.java)
    }
}
