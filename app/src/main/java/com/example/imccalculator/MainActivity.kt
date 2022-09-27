package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val peso: Float = R.id.pesoTXT.toFloat()
        val altura:Float = R.id.alturaTXT.toFloat()
        val calculoImc:String = calcularIMC(peso, altura)

        val duration =  Toast.LENGTH_SHORT
        Toast.makeText(this,calculoImc, duration).show()

        val btnCalcular = findViewById<Button>(R.id.calcularBTN).setOnClickListener {
            val intent: Intent = Intent(this, ResultActivity::class.java)
            //passando resultado para activity de resultado
            intent.putExtra("resultadoImc",calculoImc)
            startActivity(intent)
        }

    }

}




fun calcularIMC (peso: Float, altura: Float): String {
    val imc = peso / (altura * altura)

    var resultado = ""

    /* menor que 18,5 abaixo do peso ideal
       18,5 a 24,9 peso normal
       25,0 a 29,9 Acima do peso
       30,0 a 34,9 Obesidade classe 1
       35,0 a 39,9 Obesidade classe 2
       imc <= 40,0 Obesidade classe 3
     fonte OMS */

    if (imc in 0.00..18.49){
        resultado = "low"
    }
    else if(imc in 18.5..24.99){
        resultado = "normal"
    }
    else if(imc in 25.0..29.99){
        resultado = "high"
    }
    else if(imc in 30.0..34.99){
        resultado = "obesity1"
    }
    else if(imc in 35.0..39.99){
        resultado = "obesity2"
    }
    else if(imc < 40.0){
        resultado = "obesity3"
    }
    return resultado


}



