package com.pf.prova

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val infoNotaFiscal = intent.getParcelableExtra<InfoNotaFiscal>("infoNotaFiscal")




        val cpfView = findViewById<EditText>(R.id.cpfInput)
        val bancoSpinner = findViewById<Spinner>(R.id.spinnerBanco)
        val contaSpinner = findViewById<Spinner>(R.id.spinnerConta)
        val agenciaInput = findViewById<EditText>(R.id.agenciaInput)
        val digitoAgenciaInput = findViewById<EditText>(R.id.digitoAgenciaInput)
        val contaInput = findViewById<EditText>(R.id.contaInput)
        val digitoContaInput = findViewById<EditText>(R.id.digitoContaInput)
        val valorTextView = findViewById<TextView>(R.id.valor)
        val resumoTextView = findViewById<TextView>(R.id.resumo)
        val button = findViewById<Button>(R.id.button)

        cpfView.setText(infoNotaFiscal?.cpf)


        val ano = infoNotaFiscal?.semestre?.ano
        val valorInicial = infoNotaFiscal?.valor?.toDoubleOrNull() ?: 0.0
        val valorDisponivel = when (ano) {
            2020 -> valorInicial * 1.0
            2021 -> valorInicial * 0.9
            2022 -> valorInicial * 0.8
            2023 -> valorInicial * 0.7
            2024 -> valorInicial * 0.6
            else -> valorInicial
        }
        valorTextView.text = "Valor: R$ %.2f".format(valorDisponivel)


        button.setOnClickListener {

            infoNotaFiscal?.apply {
                banco = bancoSpinner.selectedItem.toString()
                conta = contaSpinner.selectedItem.toString()
                agencia = agenciaInput.text.toString()
                digitoAgencia = digitoAgenciaInput.text.toString()
                conta = contaInput.text.toString()
                digitoConta = digitoContaInput.text.toString()
                valor = valorDisponivel.toString()
            }


            Toast.makeText(this, "Pedido está em processamento...", Toast.LENGTH_SHORT).show()


            resumoTextView.text = infoNotaFiscal.toString()
        }
    }
}