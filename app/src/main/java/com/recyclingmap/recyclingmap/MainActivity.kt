package com.recyclingmap.recyclingmap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.recyclingmap.recyclingmap.ui.view.RecyclingCenterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, RecyclingCenterActivity::class.java)
        startActivity(intent)
    }
}