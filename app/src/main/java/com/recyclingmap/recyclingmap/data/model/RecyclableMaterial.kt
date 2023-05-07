// Este pacote contém o modelo de dados para um material reciclável.
package com.recyclingmap.recyclingmap.data.model

// A classe RecyclableMaterial é uma classe de dados que representa um material reciclável.
// A palavra-chave "data" indica que essa classe é usada principalmente para armazenar dados e gera automaticamente
// funções padrão, como equals(), hashCode() e toString(), bem como funções de cópia.
data class RecyclableMaterial(
    val id: Int,
    val name: String
)
