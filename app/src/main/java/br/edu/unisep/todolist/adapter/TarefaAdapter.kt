package br.edu.unisep.todolist.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import br.edu.unisep.todolist.R
import br.edu.unisep.todolist.vo.TarefaVO
import kotlinx.android.synthetic.main.item_lista.view.*

class TarefaAdapter (context: Context, cursor : Cursor?) : CursorAdapter(context, cursor, 0) {
    private val inflater = LayoutInflater.from(context)
    override fun newView(context: Context?, cursor: Cursor?, group: ViewGroup?): View {
        return inflater.inflate(R.layout.item_lista, null)
    }

    override fun bindView(item: View?, context: Context?, cursor: Cursor?) {
        val descricao = cursor?.getString(cursor?.getColumnIndex("descricao"))
        val prioridade = cursor?.getInt(cursor?.getColumnIndex("prioridade"))

        item!!.lblTarefa.text = descricao

        item!!.lblPrioridade.text = when (prioridade){
            1 -> "Baixa"
            2 -> "Média"
            else -> "Alta"
        }
    }

}