package com.example.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        /* executar quando clicar no botão calcular */
        val btnCalcular = binding.calcularBTN.setOnClickListener {
            //passando os valores recebidos para String
            val peso:Double = binding.pesoTXT.text.toString().toDouble()
            val altura:Double = binding.alturaTXT.text.toString().toDouble()


            val intent = Intent(this, ResultActivity::class.java)
            //passando resultado para activity de resultado
            intent.putExtra("peso", peso)
            intent.putExtra("altura", altura)
            startActivity(intent)

            Log.i("edit","valor de peso: $peso.text " +
                    ", valor de altura: $altura.text,")
        }


    }





}














