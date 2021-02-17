package me.vitornascimento.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        val pacote = intent.getParcelableExtra<Pacote>("pacote") as Pacote

        configuraTvPreco(pacote)

        configuraBtnFinalizarCompra(pacote)
    }

    private fun configuraBtnFinalizarCompra(pacote: Pacote) {
        binding.pagamentoBtnFinalizarCompra.setOnClickListener {
            val vaiParaResumoCompra = Intent(this, ResumoCompraActivity::class.java)
            vaiParaResumoCompra.putExtra("pacote", pacote)
            startActivity(vaiParaResumoCompra)
        }
    }

    private fun configuraTvPreco(pacote: Pacote) {
        binding.pagamentoTvPreco.text = MoedaUtil.formataParaBrasilero(pacote.preco)
    }
}