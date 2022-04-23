package com.example.prectice.SQLITE_IN_KOTLIN

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prectice.R

class SQL_Database_Activity : AppCompatActivity() {
    private lateinit var dbhelper: DBHelper
    private lateinit var dbAdapter: DB_Adapter
    val edt_name:EditText get() = findViewById(R.id.edt_name)
    val edt_mobile:EditText get() = findViewById(R.id.edt_mobile)
    val btn_read:Button get() = findViewById(R.id.btn_read)
    val btn_insert:Button get() = findViewById(R.id.btn_insert)
    var name=""
    var mobile=""
    var list= arrayListOf<DBModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_database)
        val rv=findViewById<RecyclerView>(R.id.rv)
        dbhelper= DBHelper(this)
        btn_insert.setOnClickListener{
            name=edt_name.text.toString()
            mobile=edt_mobile.text.toString()
            dbhelper.INSERT_DATA(name,mobile)
        }
        btn_read.setOnClickListener{
            list.clear()
            list=dbhelper.READ_DATA()
            dbAdapter= DB_Adapter(this,list)
            var lm=LinearLayoutManager(this)
            rv.layoutManager=lm
            rv.adapter=dbAdapter
        }
    }
}