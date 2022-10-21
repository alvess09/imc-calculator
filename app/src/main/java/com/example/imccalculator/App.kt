package com.example.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_app
import com.example.imccalculator.databinding.ActivityAppBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding : ActivityAppBinding
class App : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnNext = binding.btnNext.setOnClickListener{
            nextView()
        }
    }


    private fun nextView() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
