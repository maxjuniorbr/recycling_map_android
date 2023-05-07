package com.recyclingmap.recyclingmap.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.recyclingmap.recyclingmap.data.model.RecyclingCenter
import com.recyclingmap.recyclingmap.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class RecyclingCenterViewModel : ViewModel() {
    val recyclingCenters = MutableLiveData<List<RecyclingCenter>>()

    init {
        fetchRecyclingCenters()
    }

    private fun fetchRecyclingCenters() {
        viewModelScope.launch {
            val response = RetrofitClient.instance.getRecyclingCenters()
            recyclingCenters.value = response
        }
    }
}