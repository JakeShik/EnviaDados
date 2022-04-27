package com.example.enviadados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enviarButton = findViewById<Button>(R.id.buttonEnviar)
        enviarButton.setOnClickListener{enviaDados()}
    }


    private fun enviaDados() {

        val editTextNome = findViewById<EditText>(R.id.textName)
        val nome = editTextNome.text.toString()

        val editTextEmail = findViewById<EditText>(R.id.textEmail)
        val email = editTextEmail.text.toString()

        val editTextTelefone = findViewById<EditText>(R.id.textTelefone)
        val telefone = editTextTelefone.text.toString()


        if (nome.isBlank()) {
            editTextNome.error = getString(R.string.nome_obrigatorio)
            editTextNome.requestFocus()
            return
        }

        if (email.isBlank()) {
            editTextEmail.error = getString(R.string.nome_obrigatorio)
            editTextEmail.requestFocus()
            return
        }

        if (telefone.isBlank()) {
            editTextTelefone.error = getString(R.string.nome_obrigatorio)
            editTextTelefone.requestFocus()
            return
        }
    }
}