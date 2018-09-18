package br.edu.unisep.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.todolist.dao.TarefaDAO
import br.edu.unisep.todolist.vo.TarefaVO
import kotlinx.android.synthetic.main.activity_nova_tarefa.*

class NovaTarefaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tarefa)
    }

    fun salvar(v : View){

        val t : TarefaVO = TarefaVO()
        t.descricao = txtTarefa.text.toString()

        t.prioridade = if(gpPrioridade.checkedRadioButtonId == R.id.rdBaixa){
            1
        } else if(gpPrioridade.checkedRadioButtonId == R.id.rdMedia){
            2
        } else {
            3
        }

        val dao = TarefaDAO(this)
        dao.salvar(t)

        setResult(0)
        finish()
    }

}
