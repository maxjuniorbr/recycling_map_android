// Este pacote contém a classe MainActivity, que é a atividade principal do aplicativo.
package com.recyclingmap.recyclingmap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.recyclingmap.recyclingmap.ui.view.RecyclingCenterActivity

// A classe MainActivity herda de AppCompatActivity e é a atividade principal do aplicativo.
class MainActivity : AppCompatActivity() {
    // A função onCreate é chamada quando a atividade é criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Chama o método onCreate da classe base (AppCompatActivity).
        super.onCreate(savedInstanceState)
        // Define o layout da atividade.
        setContentView(R.layout.activity_main)

        // Cria uma nova intenção para iniciar a atividade RecyclingCenterActivity.
        val intent = Intent(this, RecyclingCenterActivity::class.java)
        // Inicia a atividade RecyclingCenterActivity.
        startActivity(intent)
    }
}