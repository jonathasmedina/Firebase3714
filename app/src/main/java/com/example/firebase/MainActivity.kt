package com.example.firebase

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth;
    private lateinit var btLogar: Button
    private lateinit var txtCriarUsuario: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btLogar = findViewById(R.id.buttonLogar)
        txtCriarUsuario = findViewById(R.id.textViewCriarUsuario)

        txtCriarUsuario.setOnClickListener {
            startActivity(Intent(this, CriarUsuario::class.java))
        }

        //autenticação
        mAuth = Firebase.auth

        //para adicionar na base de dados, no nó especificado em path
        //TODO MOVER DAQUI, ESTÁ SOMENTE PARA EXEMPLO
        val database = Firebase.database
        val myRef = database.getReference("mejjjssage")

        myRef.setValue("Hello, World 240125")

        //TODO MOVER DAQUI, ESTÁ SOMENTE PARA EXEMPLO
        // Ler um nó especifico da base de dados
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // Este metodo é chamado uma vez com o valor inicial e novamente
                // quando houver atualização dos dados
                val value = snapshot.getValue<String>()
                Log.d(TAG, "Value is: " + value + ". "+ myRef)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        btLogar.setOnClickListener {
            //TODO logar com dados do formulário, e não estes dados fixos
            mAuth.signInWithEmailAndPassword(
                    "ifms123456@gmail.com",
                "123456").addOnCompleteListener{
                if (it.isSuccessful()) {
                    startActivity(Intent(this, TelaLogado::class.java))
                }
                else
                    Toast.makeText(this, "Erro ao logar", Toast.LENGTH_SHORT).show()
            }
        }
        //TODO tela recuperar senha

    }


}