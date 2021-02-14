package me.vitornascimento.aluraviagens.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class MoedaUtil {

    companion object {
        fun formataParaBrasilero(valor: BigDecimal): String {

            return DecimalFormat
                .getCurrencyInstance(Locale("pt", "br"))
                .format(valor)
        }
    }
}