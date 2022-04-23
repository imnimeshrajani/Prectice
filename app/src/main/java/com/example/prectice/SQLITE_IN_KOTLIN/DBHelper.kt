package com.example.prectice.SQLITE_IN_KOTLIN

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(val context: Context?) : SQLiteOpenHelper(context, "Database.db",null, 1) {
    override fun onCreate(sd: SQLiteDatabase?) {
        var query="CREATE TABLE demo(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mobile TEXT)"
        sd?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun INSERT_DATA(name:String,mobile:String){
        var dbHelper=writableDatabase
        var cv=ContentValues()
        cv.put("name",name)
        cv.put("mobile",mobile)
        var res=dbHelper.insert("demo",null,cv)
        Toast.makeText(context,""+res,Toast.LENGTH_LONG).show()
    }
    @SuppressLint("Range")
    fun READ_DATA(): ArrayList<DBModel> {
        var list= arrayListOf<DBModel>()
        var db=readableDatabase
        var query="SELECT * FROM demo"
        var cursor=db.rawQuery(query,null)
        if (cursor.moveToFirst()){

            do {
                var id=cursor.getString(cursor.getColumnIndex("id"))
                var name=cursor.getString(cursor.getColumnIndex("name"))
                var mobile=cursor.getString(cursor.getColumnIndex("mobile"))
                var m= DBModel(id,name,mobile)
                list.add(m)
            }while (cursor.moveToNext())
        }
        return list
    }
    fun DELETE_DATA(id:String){

        var db=writableDatabase
        db.delete("demo","id=?", arrayOf(id))
    }
}