package br.edu.unisep.todolist.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//criar uma classe que vai gerar a conexao, e uma classe abstrata e deve ser sobscrito o oncreate e o onupgrade
class TarefaOpenHelper(context : Context) : SQLiteOpenHelper(context, "db_tarefas", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table tarefas " + " (_id integer primary key, " + " descricao text, " + " prioridade integer)"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, versaoAnterior: Int, versaoAtual: Int) {

    }

}