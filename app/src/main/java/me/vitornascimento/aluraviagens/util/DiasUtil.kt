package me.vitornascimento.aluraviagens.util

class DiasUtil {
    companion object {
        fun formataDias(qtdDias: Int): String {
            return if (qtdDias > 1) {
                "$qtdDias dias"
            } else {
                "$qtdDias dia"
            }
        }
    }
}