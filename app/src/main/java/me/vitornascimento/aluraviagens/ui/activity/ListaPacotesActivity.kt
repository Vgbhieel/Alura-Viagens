package me.vitornascimento.aluraviagens.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.aluraviagens.dao.PacoteDAO
import me.vitornascimento.aluraviagens.databinding.ActivityListaPacotesBinding
import me.vitornascimento.aluraviagens.ui.adapter.ListaPacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaPacotesBinding
    val TITULO_APPBAR = "Pacotes"
    val pacotes = PacoteDAO.lista()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaPacotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = TITULO_APPBAR

        configuraListView()
    }

    private fun configuraListView() {
        binding.listaPacotesLvItens.adapter = ListaPacotesAdapter(this, pacotes)

        binding.listaPacotesLvItens.setOnItemClickListener { _, _, position, _ ->
            val vaiParaResumoPacote = Intent(this, ResumoPacoteActivity::class.java)
            vaiParaResumoPacote.putExtra("pacote", pacotes[position])
            startActivity(vaiParaResumoPacote)
        }
    }
}