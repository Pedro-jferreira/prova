package com.pf.prova

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoNotaFiscal(
    var cpf: String,
    var valorDisponivel: String,
    var valorNaoDisponivel: String,
    var semestre: Semestre,
    var banco: String,
    var conta: String,
    var agencia: String,
    var digitoAgencia: String,
    var digitoConta: String,
    var valor: String
): Parcelable