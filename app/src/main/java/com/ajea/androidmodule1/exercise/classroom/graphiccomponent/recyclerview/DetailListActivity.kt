package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R

class DetailListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var animal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_ANIMAL", AnimalEntity::class.java)
        }else {
            intent.getSerializableExtra("EXTRA_ANIMAL") as AnimalEntity
        }

        val tvName = findViewById<TextView>(R.id.tvName)
        tvName.typeface = ResourcesCompat.getFont(this, R.font.bernier_shade_regular)


        tvName.text = animal?.name
    }
}