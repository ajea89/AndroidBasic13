package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.fragment.params

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview.AnimalEntity

class SecondParamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name  = intent.getStringExtra("EXTRA_NAME")
        val animal = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_ANIMAL", AnimalEntity::class.java)
        }else{
            intent.getSerializableExtra("EXTRA_ANIMAL") as AnimalEntity
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_second_params)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this, "name: $name animalName: ${animal?.name} animalColor: ${animal?.color}", Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}