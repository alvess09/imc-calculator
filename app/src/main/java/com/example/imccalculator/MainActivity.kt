package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_main
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val peso: Float = R.id.pesoTXT.toFloat()
        val altura: Float = R.id.alturaTXT.toFloat()

        //retorno de número de IMC
        val imc :Float  = peso / altura * altura

        //TODO("formatar o numero  e depois calcular corretamente ")

        //retorno de índice de IMC
        val calculoImc: String = verificaIndice(imc)

       /* val numeroFormatado: DecimalFormat = DecimalFormat("#,###.00")
        numeroFormatado.format(imc)*/

        val duracao =  Toast.LENGTH_SHORT
        Toast.makeText(this,calculoImc, duracao).show()

        val btnCalcular = findViewById<Button>(R.id.calcularBTN).setOnClickListener {
            val intent: Intent = Intent(this, ResultActivity::class.java)
            //passando resultado para activity de resultado
            intent.putExtra("resultadoIndice",calculoImc)
            intent.putExtra("numeroImc",numeroFormatado)
            startActivity(intent)
        }

    }

}




fun verificaIndice (imc: Float): String {


    var resultado = ""

    /* menor que 18,5 abaixo do peso ideal
       18,5 a 24,9 peso normal
       25,0 a 29,9 Acima do peso
       30,0 a 34,9 Obesidade classe 1
       35,0 a 39,9 Obesidade classe 2
       imc <= 40,0 Obesidade classe 3
     fonte OMS */

    if(imc in 0.00..18.49){
        resultado = "low"
    }
    if(imc in 18.5..24.99){
        resultado = "normal"
    }
    if(imc in 25.0..29.99){
        resultado = "high"
    }
    if(imc in 30.0..34.99){
        resultado = "obesity1"
    }
    if(imc in 35.0..39.99){
        resultado = "obesity2"
    }
    if(imc < 40.0){
        resultado = "obesity3"
    }
    return resultado

}



