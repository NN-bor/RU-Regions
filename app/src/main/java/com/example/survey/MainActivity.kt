package com.example.survey

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button)

        startButton.setOnClickListener {
            val transition = Intent(this, MainActivity2::class.java)
            startActivity(transition)
        }
    }
}