// Este pacote contém o modelo de dados para um centro de reciclagem.
package com.recyclingmap.recyclingmap.data.model

// A classe RecyclingCenter é uma classe de dados que representa um centro de reciclagem.
// A palavra-chave "data" indica que essa classe é usada principalmente para armazenar dados e gera automaticamente
// funções padrão, como equals(), hashCode() e toString(), bem como funções de cópia.
data class RecyclingCenter(
    val id: Int,
    val name: String,
    val address: String,
    var latitude: String,
    var longitude: String,
    val recyclable_materials: List<RecyclableMaterial>
)