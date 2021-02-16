package me.vitornascimento.aluraviagens.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.aluraviagens.dao.PacoteDAO
import me.vitornascimento.aluraviagens.databinding.ActivityResumoPacoteBinding
import me.vitornascimento.aluraviagens.model.Pacote
import me.vitornascimento.aluraviagens.util.DiasUtil
import me.vitornascimento.aluraviagens.util.MoedaUtil

class ResumoPacoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityResumoPacoteBinding
    val TITULO_APPBAR = "Resumo do Pacote"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoPacoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = TITULO_APPBAR

        val dao = PacoteDAO()
        val pacotes = dao.lista()
        val pacote = pacotes[0]

        configuraIvCidade(pacote)

        configuraTvCidade(pacote)

        configuraTvDias(pacote)

        configuraTvPreco(pacote)

        configuraTvData(pacote)

    }

    private fun configuraTvData(pacote: Pacote) {
        binding.resumoPacoteTvData.text = DiasUtil.formataDataViagem(pacote.dias)
    }

    private fun configuraTvPreco(pacote: Pacote) {
        binding.resumoPacoteTvPreco.text = MoedaUtil.formataParaBrasilero(pacote.preco)
    }

    private fun configuraIvCidade(pacote: Pacote) {
        binding.resumoPacoteIvCidade.setImageResource(
            this.resources.getIdentifier(
                pacote.imagem,
                "drawable",
                this.packageName
            )
        )
    }

    private fun configuraTvDias(pacote: Pacote) {
        binding.resumoPacoteTvDias.text = DiasUtil.formataDias(pacote.dias)
    }

    private fun configuraTvCidade(pacote: Pacote) {
        binding.resumoPacoteTvCidade.text = pacote.local
    }
}