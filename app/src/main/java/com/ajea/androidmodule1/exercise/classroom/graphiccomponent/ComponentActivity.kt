package com.ajea.androidmodule1.exercise.classroom.graphiccomponent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R

class ComponentActivity : AppCompatActivity() {

    lateinit var tvExample : TextView
    lateinit var etExample : EditText
    lateinit var btExample : Button
    lateinit var ivExample : ImageView
    lateinit var ibExample : ImageButton
    lateinit var cbExample : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_component)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvExample = findViewById(R.id.tvExample)
        etExample = findViewById(R.id.etExample)
        btExample = findViewById(R.id.btExample)
        ivExample = findViewById(R.id.ivExample)
        ibExample = findViewById(R.id.ibExample)
        cbExample = findViewById(R.id.cbExample)

        cbExample.isChecked = false
        cbExample.setOnCheckedChangeListener { buttonView, isChecked->

            if (isChecked){
                ivExample.visibility = View.INVISIBLE
            }else{
                ivExample.visibility = View.VISIBLE
            }
        }

        val pass = etExample.text
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show()

        btExample.setOnClickListener {
            val cbStatus = cbExample.isChecked
            Toast.makeText(this, "$cbStatus", Toast.LENGTH_SHORT).show()
        }

        ibExample.setOnClickListener {
            Toast.makeText(this, etExample.text, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onResume() {
        super.onResume()
        tvExample.text = "Cargué mi texto en el método onResume"
    }
}