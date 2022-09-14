package com.example.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    //apresentar resultado em um card


    private fun setListeners() {
        val peso: Float = R.id.pesoTXT.toFloat()
        val altura: Float = R.id.alturaTXT.toFloat()
        val resultado  = calcularIMC(peso, altura)

        val btnCalcular = findViewById<Button>(R.id.calcularBTN)
        val duration = Toast.LENGTH_SHORT

        btnCalcular.setOnClickListener{
            val toast = Toast.makeText(this, resultado, duration).setGravity(top).show()
        }


    }

     fun calcularIMC (peso: Float, altura: Float): String {
        val imc = peso / (altura * 2)
        var resultado: String = ""
        /* menor que 18,5 abaixo do peso ideal
         18,5 a 24,9 peso normal
         25,0 a 29,9 Acima do peso
         30,0 a 34,9 Obesidade classe 1
         35,0 a 39,9 Obesidade classe 2
         imc <= 40,0 Obesidade classe 3
         fonte OMS */

        if (imc < 18.5){
                    resultado = "abaixo do peso normal"
                }else if(imc > 18.5 && imc < 25.0){
                    resultado = "Peso Normal"
                }else if(imc > 25.0 && imc < 30.0){
                    resultado = "Obesidade Classe 1"
                }else if(imc > 30.0 && imc < 35.0){
                    resultado = "Obesidade Classe 2"
                }else if(imc > 35.0 && imc < 40.0){
                    resultado = "Obesidade Classe 3"
                }
        return resultado


       }
    }


