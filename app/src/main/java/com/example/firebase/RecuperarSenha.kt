package com.example.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RecuperarSenha : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        mAuth = Firebase.auth

        //TODO fazer tela e receber email do usuário, findViewById, etc
        mAuth.sendPasswordResetEmail("email").addOnCompleteListener{
            if (it.isSuccessful()) {
                Toast.makeText(this, "Email enviado", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "Erro ao enviar email", Toast.LENGTH_SHORT).show()
        }

    }
}