package com.ajea.androidmodule1.exercise.classroom

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidmodule1.R

class LifeCicleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.e("LifeCicle","onCreate")

        Toast.makeText(this, "onCreate",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()

        Log.e("LifeCicle","onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("LifeCicle","onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e("LifeCicle","onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("LifeCicle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("LifeCicle","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()

        Log.e("LifeCicle","onRestart")
    }

}