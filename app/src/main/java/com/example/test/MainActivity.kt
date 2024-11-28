package com.example.test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun onButtonClick(view: android.view.View) {
        Toast.makeText(this, "Knappen är klickad!", Toast.LENGTH_SHORT).show()
    }
}

