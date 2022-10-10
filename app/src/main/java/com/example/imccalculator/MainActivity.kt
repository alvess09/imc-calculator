package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_main

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        //passando os valores recebidos para String
        val peso: String = R.id.pesoTXT.toString()
        val altura: String = R.id.alturaTXT.toString()

        /* executar quando clicar no botão calcular */

        val btnCalcular = findViewById<Button>(R.id.calcularBTN).setOnClickListener {

            val intent = Intent(this, ResultActivity::class.java)
            //passando resultado para activity de resultado
            intent.putExtra("peso", peso)
            intent.putExtra("altura", altura)
            startActivity(intent)

            Log.i("edit","valor de peso: $peso " +
                    ", valor de altura: $altura,")
        }

    }





}














