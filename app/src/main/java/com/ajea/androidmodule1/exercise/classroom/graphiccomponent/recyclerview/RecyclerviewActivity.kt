package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.databinding.ActivityRecyclerviewBinding

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setTitle("Home")
        //supportActionBar?.setDisplayShowTitleEnabled(false)


        val data = listOf(AnimalEntity("Leon","Amarillo", ""),
            AnimalEntity("Perro", "Café", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Zorro", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            )

        val adapter = AnimalAdapter(data)
        adapter.onItemSelected = { animal ->
            val intent = Intent(this, DetailListActivity::class.java).apply {
                putExtra("EXTRA_ANIMAL", animal)
            }

            startActivity(intent)
//            Toast.makeText(this, "Animal seleccionado: ${animal.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvAnimal.adapter = adapter
        binding.rvAnimal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}