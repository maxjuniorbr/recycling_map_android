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

class RecyclingCenterActivity : AppCompatActivity() {

    private lateinit var viewModel: RecyclingCenterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycling_center)

        viewModel = ViewModelProvider(this).get(RecyclingCenterViewModel::class.java)

        val adapter = RecyclingCenterAdapter { recyclingCenter ->
            val gmmIntentUri =
                Uri.parse("geo:${recyclingCenter.latitude},${recyclingCenter.longitude}?q=${recyclingCenter.latitude},${recyclingCenter.longitude}(${recyclingCenter.name})")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            startActivity(mapIntent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.recyclingCenters.observe(this, Observer { centers ->
            adapter.submitList(centers)
        })
    }
}
