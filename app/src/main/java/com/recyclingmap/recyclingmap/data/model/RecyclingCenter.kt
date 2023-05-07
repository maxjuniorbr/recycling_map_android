package com.recyclingmap.recyclingmap.data.model

data class RecyclingCenter(
    val id: Int,
    val name: String,
    val address: String,
    var latitude: String,
    var longitude: String,
    val recyclable_materials: List<RecyclableMaterial>
)