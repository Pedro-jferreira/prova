package com.pf.prova

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotaFiscalActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var semestres: List<Semestre>? = emptyList()
    private lateinit var adapter: AdapterSemestre
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nota_fiscal)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
// Configura o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
// Obtenha a lista de planetas
        semestres = SemestreData.getSemestre()
// Configura o Adapter e o click listener
        adapter = AdapterSemestre(this, semestres,OnclickSemestre())
        recyclerView.adapter = adapter
    }

    private fun OnclickSemestre(): AdapterSemestre.SemestreOnclickListener {
        return object : AdapterSemestre.SemestreOnclickListener {
            override fun OnclickSemestre(holder: AdapterSemestre.SemestreViewHolder?, idx: Int) {
                val semestre = semestres?.get(idx)
                semestre.let {
                    val cpf = recyclerView.findViewById<EditText>(R.id.cpfInput).text.toString()
                    val valorDisponivel = recyclerView.findViewById<EditText>(R.id.valorDisponivelInput).text.toString()
                    val valorNaoDisponivel = recyclerView.findViewById<EditText>(R.id.valorNaoDisponivelInput).text.toString()

                    val infoNotaFiscal = InfoNotaFiscal(
                        semestre = semestre.let { semestre }!!,
                        cpf = cpf,
                        valorDisponivel = valorDisponivel,
                        valorNaoDisponivel = valorNaoDisponivel,
                        banco = "",
                        conta = "",
                        agencia = "",
                        digitoAgencia = "",
                        digitoConta = "",
                        valor = ""
                    )

                    val intent = Intent(this@NotaFiscalActivity, Resultado::class.java)
                    intent.putExtra("infoNotaFiscal", infoNotaFiscal)
                    startActivity(intent) }


            }
        }
    }
}