package me.vitornascimento.aluraviagens.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.aluraviagens.dao.PacoteDAO
import me.vitornascimento.aluraviagens.databinding.ActivityResumoCompraBinding
import me.vitornascimento.aluraviagens.model.Pacote
import me.vitornascimento.aluraviagens.util.DiasUtil
import me.vitornascimento.aluraviagens.util.MoedaUtil

class ResumoCompraActivity : AppCompatActivity() {

    lateinit var binding: ActivityResumoCompraBinding
    val TITULO_APPBAR = "Resumo da Compra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoCompraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = TITULO_APPBAR

        val dao = PacoteDAO()
        val pacotes = dao.lista()
        val pacote = pacotes[0]

        configuraIvCidade(pacote)

        configuraTvCidade(pacote)

        configuraTvPreco(pacote)

        configuraTvData(pacote)
    }


    private fun configuraTvData(pacote: Pacote) {
        binding.resumoCompraTvData.text = DiasUtil.formataDataViagem(pacote.dias)
    }

    private fun configuraTvPreco(pacote: Pacote) {
        binding.resumoCompraTvPreco.text = MoedaUtil.formataParaBrasilero(pacote.preco)
    }

    private fun configuraIvCidade(pacote: Pacote) {
        binding.resumoCompraIvCidade.setImageResource(
            this.resources.getIdentifier(
                pacote.imagem,
                "drawable",
                this.packageName
            )
        )
    }

    private fun configuraTvCidade(pacote: Pacote) {
        binding.resumoCompraTvCidade.text = pacote.local
    }
}