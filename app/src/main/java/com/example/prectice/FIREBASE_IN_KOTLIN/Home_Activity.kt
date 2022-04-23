package com.example.prectice.FIREBASE_IN_KOTLIN

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.prectice.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Home_Activity : AppCompatActivity() {
    val edt_name:EditText get() = findViewById(R.id.edt_name)
    val edt_mobile:EditText get() = findViewById(R.id.edt_mobile)
    val btn_add_data:Button get() = findViewById(R.id.btn_add_data)
    val btn_read_data:Button get() = findViewById(R.id.btn_read_data)
    val database = Firebase.database
    private lateinit var dr: DatabaseReference
    val myRef = database.getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_add_data.setOnClickListener {

        }
        btn_read_data.setOnClickListener {

        }
    }
}