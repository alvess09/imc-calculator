package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val btnCalcular = findViewById<Button>(R.id.calcularBTN).setOnClickListener {
            val intent: Intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)

        }

    }


    private val peso: Float by lazy { R.id.pesoTXT.toFloat() }
    private val altura:Float by lazy { R.id.alturaTXT.toFloat() }
    val calculoImc:String by lazy { calcularIMC(peso, altura) }



    }




fun calcularIMC (peso: Float, altura: Float): String {
    val imc = peso / (altura * 2)
    var resultado = ""
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



