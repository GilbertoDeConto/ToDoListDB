package br.edu.unisep.todolist

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.edu.unisep.todolist.adapter.TarefaAdapter
import br.edu.unisep.todolist.dao.TarefaDAO
import br.edu.unisep.todolist.vo.TarefaVO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter : TarefaAdapter? = null

    private var cursor : Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TarefaAdapter(this, cursor)
        listTarefas.adapter = adapter

        listar()
    }

    fun listar (){
        val dao = TarefaDAO(this)
        cursor = dao.listar()

        adapter!!.swapCursor(cursor)
        adapter!!.notifyDataSetChanged()
    }


    /*
    Metodo que realiza a criacao d oobjeto do menu na tela nesse metodo e definido qualarquivo contem o layout de menu a ser criado
    */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_tarefas, menu)

        return true
    }

    /*
    metodo executado sempre que uma opcao de menu e a cionada pelo usuario na tela. atraves do itemid do item selecionado pode se verificar a opcao do usuario
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.mnNovaTarefa){
            val i : Intent = Intent(this, NovaTarefaActivity::class.java)
            startActivityForResult(i, 1)
        }

        return true;
    }

    /*
        Método executado apos o retorno de uma activity que foi iniciada através
        do método startActivityForResult
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 1){
            listar()
        }
    }

}
