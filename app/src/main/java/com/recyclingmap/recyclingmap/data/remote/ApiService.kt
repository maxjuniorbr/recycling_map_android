package com.recyclingmap.recyclingmap.data.remote

import com.recyclingmap.recyclingmap.data.model.RecyclingCenter
import retrofit2.http.GET

interface ApiService {
    @GET("recycling_centers")
    suspend fun getRecyclingCenters(): List<RecyclingCenter>
}