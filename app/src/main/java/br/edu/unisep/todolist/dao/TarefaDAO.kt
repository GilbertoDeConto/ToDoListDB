package br.edu.unisep.todolist.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import br.edu.unisep.todolist.helper.TarefaOpenHelper
import br.edu.unisep.todolist.vo.TarefaVO

class TarefaDAO (context : Context) {
    private val helper : TarefaOpenHelper = TarefaOpenHelper(context)

    fun salvar(tarefa : TarefaVO){
        val db = helper.writableDatabase

        val valores = ContentValues()
        valores.put("descricao", tarefa.descricao)
        valores.put("prioridade", tarefa.prioridade)

        db.insert("tarefas", null, valores)
    }

    fun listar() : Cursor{
        val db = helper.readableDatabase
        val crs = db.rawQuery("select * from tarefas", null)

        return crs
    }
}