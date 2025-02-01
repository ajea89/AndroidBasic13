package com.ajea.androidmodule1.exercise.classroom.explictintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val btnReturnInfo = findViewById<Button>(R.id.btnReturnInfo)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME")){
                val name = it.getString("EXTRA_NAME")
                tvName.text = name
            }

            if (it.containsKey("EXTRA_MARRIED")){
                val isMarried = it.getBoolean("EXTRA_MARRIED")
                Toast.makeText(this, "Eres casado?: ${if(isMarried) "si" else "no"}", Toast.LENGTH_LONG).show()
            }

            if (it.containsKey("EXTRA_AGE")){
                val age = it.getInt("EXTRA_AGE")
                tvAge.text = age.toString()
//                Toast.makeText(this, "Tu edad es de $age años", Toast.LENGTH_LONG).show()
            }
        }

        btnReturnInfo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT", false)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}