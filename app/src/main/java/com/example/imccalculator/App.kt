package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_app

class App : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_app)

        val btnNext = findViewById<Button>(R.id.btn_next).setOnClickListener{
            nextView()
        }
    }


    private fun nextView() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
