package com.example.appsegundamano

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity

object UsuariosConexionHelper {

    /*
    /**
     * Añado un usuario a la base de datos
     */
    fun addUsuario(contexto: AppCompatActivity, u: Usuario):Long{

        //Creo una instancia para poder conectarme a la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        val registro = ContentValues()
        registro.put("id", u.id) //Añado el id del usuario nuevo
        registro.put("nombre", u.nombre) //Añado el nombre del usuario nuevo
        registro.put("password", u.password) //Añado la contraseña del usuario nuevo
        registro.put("urlImagen", u.urlImagen) //Añado la url de la imagen del usuario nuevo


        //Inserto en la bbdd
        //.insert devuelve el id de la fila insertada
        val idFilaInsertada = bd.insert("usuarios", null, registro)

        //Cierro la conexion
        bd.close()

        //Devuelvo el id de la fila insertada o -1 en caso de error
        return idFilaInsertada
    }
    */


    /*
    /**
     * Borras un usuario de la bbdd
     */
    fun  borrarUsuario(contexto: AppCompatActivity, id:Int):Int{

        //Creo una instancia para poder conectarme a la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        //Borro un usuario cuyo id es el pasado por parametro
        //Devuelve el numero de filas afectadas
        val cantFilasAfectadas = bd.delete("usuarios", "id=?", arrayOf(id.toString()))

        //Cierro la conexion
        bd.close()

        //Devuelvo el numero de filas afectadas
        return cantFilasAfectadas
    }
*/
    /*
    /**
     * Modificas un usuario de la bbdd
     */
    fun modificarUsuario(contexto: AppCompatActivity, id:Int, u:Usuario):Int{

        //Creo la instancia a la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permito modificar la bbdd
        val bd: SQLiteDatabase = admin.writableDatabase

        val registro = ContentValues()
        registro.put("id", u.id)
        registro.put("nombre", u.nombre)
        registro.put("password", u.password)
        registro.put("urlImagen", u.urlImagen)

        //Actualizo los datos en la bbdd
        //Devuelve el numero de filas afectadas
        val numeroFilasAfectadas = bd.update("usuarios", registro, "id=?", arrayOf(id.toString()))

        //Cierro la conexion
        bd.close()

        //Devuelvo el numero de filas afectadas
        return numeroFilasAfectadas
    }
    */

    /*
    /**
     * Buscar el usuario que tenga el id pasado por parametro
     */
    fun buscarUsuario(contexto: AppCompatActivity, id:Int):Usuario? {

        //Creo un objeto usuario
        var u:Usuario? = null

        //Creo la instancia
        val admin = AdminSQLiteConexion(contexto)

        //Permito que solo pueda leer
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultset con los usuarios recogidos de la bbdd
        val fila =bd.rawQuery(
            "SELECT id, nombre, password, urlImagen FROM usuarios WHERE id=?",
            arrayOf(id.toString())
        )

        //Si hay datos .moveToFirst devuelve true, si no false
        if (fila.moveToFirst()) {
            //Creo un objeto usuario dandole los valores de un usuario recogido
            u = Usuario( fila.getInt(0), fila.getString(1), fila.getString(2), fila.getString(3) );
        }
        bd.close()
        return u
    }
*/

    /**
     * Te devuelve todos los usuarios de la bbdd
     */
    fun obtenerUsuarios(contexto: AppCompatActivity):ArrayList<Usuario>{

        //ArrayList para meter los usuarios de la bbdd
        var usuarios:ArrayList<Usuario> = ArrayList(1)

        //Abres la conexion en la bbdd
        val admin = AdminSQLiteConexion(contexto)

        //Permisos de solo lectura
        val bd: SQLiteDatabase = admin.readableDatabase

        //Devuelve un resultSet
        val fila = bd.rawQuery("select id,nombre,password,urlImagen from usuarios", null)

        while (fila.moveToNext()) { //Si fila (ResultSet) tiene mas contenido del leido
            //Creo un usuario
            var u:Usuario = Usuario( fila.getInt(0), fila.getString(1), fila.getString(2), fila.getString(3) )
            //Lo guardo en la lista
            usuarios.add(u)
        }
        //Cierro la conexion
        bd.close()
        //Devuelvo la lista de usuarios
        return usuarios
    }

}