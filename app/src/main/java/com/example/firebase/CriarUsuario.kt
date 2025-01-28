package com.example.firebase

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class CriarUsuario : AppCompatActivity() {

    private lateinit var btCriarUsuario: Button
    private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_usuario)

        auth = Firebase.auth


        btCriarUsuario = findViewById(R.id.buttonLogar)
        btCriarUsuario.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                "ifms123456@gmail.com",
                "123456")
            //TODO criar usuário a partir de dados do formulário
        }

    }
}