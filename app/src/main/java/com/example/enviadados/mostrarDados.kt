package com.example.enviadados

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class mostrarDados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostra_dados)


        val nome = intent.getStringExtra(MainActivity.EXTRA_NOME)
        val textViewNome = findViewById<TextView>(R.id.textViewNome)
        textViewNome.text = nome
    }


}