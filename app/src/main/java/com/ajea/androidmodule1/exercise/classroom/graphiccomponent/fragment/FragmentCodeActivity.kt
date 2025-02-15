package com.ajea.androidmodule1.exercise.classroom.graphiccomponent.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R
import com.ajea.androidmodule1.databinding.ActivityFragmentCodeBinding

class FragmentCodeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentCodeBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerCode, ExampleFragment.newInstance())
            .commit()
    }
}