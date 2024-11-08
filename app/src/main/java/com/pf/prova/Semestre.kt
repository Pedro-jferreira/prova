package com.pf.prova

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Semestre(val ano: Int, val semestre: Int): Parcelable
object SemestreData {
    fun getSemestre(): List<Semestre> {
        return listOf(
            Semestre(ano=2020, semestre=1),
            Semestre(ano=2020, semestre=2),
            Semestre(ano=2021, semestre=1),
            Semestre(ano=2021, semestre=2),
            Semestre(ano=2022, semestre=1),
            Semestre(ano=2022, semestre=2),
            Semestre(ano=2023, semestre=1),
            Semestre(ano=2023, semestre=2),
            Semestre(ano=2024, semestre=1),
            Semestre(ano=2024, semestre=2))
    }
}
