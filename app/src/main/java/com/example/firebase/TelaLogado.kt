package com.example.firebase

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class TelaLogado : AppCompatActivity() {

    private lateinit var btLogout: Button
    private lateinit var mAuth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_logado)

        mAuth = Firebase.auth

        btLogout = findViewById(R.id.buttonLogout)
        btLogout.setOnClickListener {
            mAuth.signOut()
            finish()
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
        }
    }
}