package com.example.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
     private val alturaEDT: TextView? = findViewById(R.id.alturaEDT)
     private val pesoEDT: TextView? = findViewById(R.id.pesoEDT)
     private val calcularBTN: Button? = findViewById(R.id.calcularBTN)
     private val titleTXT: TextView? = findViewById(R.id.titleTXT)

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
           // Toast.makeText(this,text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged{ text, _, _, _ ->

        }
        calcularBTN?.setOnClicListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString)
        }
    }
    private fun calcularIMC (peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
         val imc = peso / (altura * altura)
         titleTXT.text = "Seu IMC é de: $imc.2f".format(imc)
        }
    }
}