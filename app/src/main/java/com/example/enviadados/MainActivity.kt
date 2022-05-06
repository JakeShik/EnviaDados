package com.example.enviadados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {
    private var dataNascimento: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enviarButton = findViewById<Button>(R.id.buttonEnviar)
        enviarButton.setOnClickListener{    enviaDados()    }

        val calendarViewDataDeNascimento = findViewById<CalendarView>(R.id.calendarViewDataNascimento)
        dataNascimento = calendarViewDataDeNascimento.date

        calendarViewDataDeNascimento.setOnDateChangeListener{calendarView, ano,mes,dia ->
            val calendario = Calendar.getInstance()
            calendario.set(ano, mes, dia)
            dataNascimento = calendario.timeInMillis
        }
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
            editTextEmail.error = getString(R.string.email_obrigatorio)
            editTextEmail.requestFocus()
            return
        }

        val telefoneValido = Patterns.PHONE.matcher(telefone).matches()
        if (!telefoneValido) {
            editTextTelefone.error = getString(R.string.telefone_invalido)
            editTextTelefone.requestFocus()
            return
        }
        val intent = Intent(this, mostrarDados::class.java)


        intent.putExtra(EXTRA_NOME, nome)
        intent.putExtra(EXTRA_EMAIL, email)
        intent.putExtra(EXTRA_TELEFONE, telefone)
        intent.putExtra(EXTRA_DATA_NASCIMENTO, dataNascimento)

        startActivity(intent)


    }
    companion object{
        const val EXTRA_NOME = "NOME"
        const val EXTRA_EMAIL = "EMAIL"
        const val EXTRA_TELEFONE = "TELEFONE"
        const val EXTRA_DATA_NASCIMENTO = "DATA"
    }
}