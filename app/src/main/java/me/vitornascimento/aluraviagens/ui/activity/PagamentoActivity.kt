package me.vitornascimento.aluraviagens.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.aluraviagens.R
import me.vitornascimento.aluraviagens.dao.PacoteDAO
import me.vitornascimento.aluraviagens.databinding.ActivityPagamentoBinding
import me.vitornascimento.aluraviagens.model.Pacote
import me.vitornascimento.aluraviagens.util.MoedaUtil

class PagamentoActivity : AppCompatActivity() {

    lateinit var binding: ActivityPagamentoBinding
    val TITULO_APPBAR = "Pagamento"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagamentoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = TITULO_APPBAR

        val dao = PacoteDAO()
        val pacotes = dao.lista()
        val pacote = pacotes[0]

        configuraTvPreco(pacote)

    }

    private fun configuraTvPreco(pacote: Pacote) {
        binding.pagamentoTvPreco.text = MoedaUtil.formataParaBrasilero(pacote.preco)
    }
}