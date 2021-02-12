package me.vitornascimento.aluraviagens.model

import android.icu.math.BigDecimal
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pacote(var local: String, var imagem: String, var dias: Int, var preco: BigDecimal) :
    Parcelable