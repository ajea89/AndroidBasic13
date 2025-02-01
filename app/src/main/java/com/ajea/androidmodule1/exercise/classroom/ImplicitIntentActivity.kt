package com.ajea.androidmodule1.exercise.classroom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R

class ImplicitIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContentView(R.layout.activity_implicit_intent)

        val btnSend = findViewById<Button>(R.id.btnSendIntent)
        val btnOpenUrl = findViewById<Button>(R.id.btnOpenUrl)

        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, "ajea@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT, "Este es un mensaje de prueba para un intent implicito")
            }

            startActivity(Intent.createChooser(emailIntent, "Abrir usando:"))
        }

        btnOpenUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando:"))
        }

    }
}