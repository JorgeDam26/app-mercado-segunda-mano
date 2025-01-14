package com.example.appsegundamano

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class AdminSQLIteConexion (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, name, factory, version) {

    //Si hay algún cambio en la BBDD, se cambia el número de versión y así automáticamente
    companion object {
        val DATABASE_VERSION: Int = 1
        val DATABASE_NAME: String = "appSegundaMano.db"
    }

    constructor(context: Context): this(context, DATABASE_NAME, null, DATABASE_VERSION){
    }

    //Se ejecuta la primera vez para crear las tablas y añadir los datos
    //Solo se ejecuta 1 vez
    override fun onCreate(db: SQLiteDatabase?) {
        Log.e("SQLLite","Paso por onCreate del AdminSQLIteConexion")

        db.execSQL("create table usuarios(id int primary key, nombre text, password text, urlImagen text)")
        db.execSQL("create table productos(id int primary key, nombre text, precio real, urlImagen text)")
    }

    //Este metodo se ejecuta el resto de veces, no es necesario hacer nada
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.e("SQLLite","Paso por OnUpgrade del AdminSQLIteConexion")

    }
}