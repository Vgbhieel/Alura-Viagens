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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaPacotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = TITULO_APPBAR

        configuraListView()

        startActivity(Intent(this, ResumoCompraActivity::class.java))
    }

    private fun configuraListView() {
        val listView = binding.listaPacotesLvItens
        val dao = PacoteDAO()
        listView.adapter = ListaPacotesAdapter(this, dao.lista())
    }
}