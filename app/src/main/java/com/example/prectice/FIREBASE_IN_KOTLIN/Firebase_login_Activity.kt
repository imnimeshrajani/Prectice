package com.example.prectice.FIREBASE_IN_KOTLIN

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.prectice.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Firebase_login_Activity : AppCompatActivity() {

    val edt_email: EditText get() = findViewById(R.id.edt_email)
    val edt_password: EditText get() = findViewById(R.id.edt_password)
    val btn_submit: Button get() = findViewById(R.id.btn_submit)
    val btn_sing_in: Button get() = findViewById(R.id.btn_sing_in)
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_login)

        auth = Firebase.auth
        btn_submit.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                edt_email.text.toString(),
                edt_password.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information

                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext, "Authentication Succeed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent=Intent(this,Home_Activity::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
        }
        btn_sing_in.setOnClickListener {
            auth.signInWithEmailAndPassword(edt_email.text.toString(), edt_password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "Sing-in Succeed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent=Intent(this,Home_Activity::class.java)
                        startActivity(intent)
                        val user = auth.currentUser
                    } else {
                        Toast.makeText(
                            baseContext, "Sing-in failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}