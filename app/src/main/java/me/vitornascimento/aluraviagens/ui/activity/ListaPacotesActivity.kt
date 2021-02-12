package me.vitornascimento.aluraviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.vitornascimento.aluraviagens.R
import me.vitornascimento.aluraviagens.databinding.ActivityListaPacotesBinding

class ListaPacotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaPacotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaPacotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}