package me.vitornascimento.aluraviagens.util

import java.text.SimpleDateFormat
import java.util.*

class DiasUtil {
    companion object {
        fun formataDias(qtdDias: Int): String {
            return if (qtdDias > 1) {
                "$qtdDias dias"
            } else {
                "$qtdDias dia"
            }
        }

        fun formataDataViagem(dias: Int): String {
            val formatoDdMm = SimpleDateFormat("dd/MM")
            val dataIda = Calendar.getInstance()
            val dataRetorno = Calendar.getInstance()
            dataRetorno.add(Calendar.DATE, dias)
            val dataAtualFormatada = formatoDdMm.format(dataIda.time)
            val dataRetornoFormatada = formatoDdMm.format(dataRetorno.time)
            val ano = dataRetorno.get(Calendar.YEAR)
            return "$dataAtualFormatada - $dataRetornoFormatada de $ano"
        }
    }
}