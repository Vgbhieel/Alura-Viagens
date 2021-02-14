package me.vitornascimento.aluraviagens.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Pacote(var local: String, var imagem: String, var dias: Int, var preco: BigDecimal) :
    Parcelable