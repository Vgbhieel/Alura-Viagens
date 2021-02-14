package me.vitornascimento.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.vitornascimento.aluraviagens.R
import me.vitornascimento.aluraviagens.model.Pacote
import java.text.DecimalFormat
import java.util.*

class ListaPacotesAdapter(val context: Context, val pacotes: List<Pacote>) : BaseAdapter() {


    override fun getCount(): Int {
        return this.pacotes.size
    }

    override fun getItem(position: Int): Pacote {
        return this.pacotes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false)
        val pacote = pacotes[position]

        configuraTvLocal(view, pacote)

        configuraIvLocal(view, pacote)

        configuraTvDias(view, pacote)

        configuraTvPreco(view, pacote)

        return view
    }

    private fun configuraTvPreco(
        view: View,
        pacote: Pacote
    ) {
        val tvPreco: TextView = view.findViewById(R.id.item_pacote_tv_preco)
        val formatoBrasileiro = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
        tvPreco.text = formatoBrasileiro.format(pacote.preco)
    }

    private fun configuraTvDias(
        view: View,
        pacote: Pacote
    ) {
        val tvDias: TextView = view.findViewById(R.id.item_pacote_tv_dias)
        val qtdDias = pacote.dias
        val diasToString: String
        if (qtdDias > 1) {
            diasToString = qtdDias.toString() + " dias"
            tvDias.text = diasToString
        } else {
            diasToString = qtdDias.toString() + " dia"
            tvDias.text = diasToString
        }
    }

    private fun configuraIvLocal(
        view: View,
        pacote: Pacote
    ) {
        val ivCidade: ImageView = view.findViewById(R.id.item_pacote_iv_cidade)
        val resources = context.resources
        ivCidade.setImageResource(
            resources.getIdentifier(
                pacote.imagem,
                "drawable",
                context.packageName
            )
        )
    }

    private fun configuraTvLocal(
        view: View,
        pacote: Pacote
    ) {
        val tvLocal: TextView = view.findViewById(R.id.item_pacote_tv_cidade)
        tvLocal.text = pacote.local
    }

}
