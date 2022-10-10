package com.example.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.imccalculator.R.layout.activity_resut


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_resut)

        val dados = this.intent.extras
        val peso = dados?.getString("peso")
        val altura = dados?.getString("altura")

        val imc = calcularImc(peso.toString(), altura.toString())

        val indiceResultado = calculaIndice(imc)






        //configurar a cor do circulo de acordo com o resultado
        alteraCorDoCirculo(indiceResultado)

        val duration =  Toast.LENGTH_SHORT
        Toast.makeText(this, indiceResultado, duration).show()


    }
    @SuppressLint("SetTextI18n")
    private fun calcularImc(peso: String, altura: String) :Float{

        val pesoConvertido = peso.toFloatOrNull()
        val alturaConvertida = altura.toFloatOrNull()
        var imc = 0.0F
        val numeroImc = findViewById<TextView>(R.id.tv_result_number)

        if (pesoConvertido != null && alturaConvertida != null){
            imc = pesoConvertido / (alturaConvertida * alturaConvertida)

            numeroImc.text = " %.2f".format(imc)
        }
       return imc
    }

    private fun calculaIndice(imc:Float):String {
        var resultado = ""

        /* menor que 18,5 abaixo do peso ideal
           18,5 a 24,9 peso normal
           25,0 a 29,9 Acima do peso
           30,0 a 34,9 Obesidade classe 1
           35,0 a 39,9 Obesidade classe 2
           imc <= 40,0 Obesidade classe 3
         fonte OMS */

        if(imc < 18.49){
            "low".also { resultado = it }
        }
        if(imc > 18.5 && imc <= 24.99){
            "normal".also { resultado = it }
        }
        if(imc > 25.0 && imc <= 29.99){
            "high".also { resultado = it }
        }
        if(imc > 30.0 && imc <= 34.99){
            "obesity1".also { resultado = it }
        }
        if(imc > 35.0 && imc <= 39.99){
            "obesity2".also { resultado = it }
        }
        if(imc < 40.0){
            "obesity3".also { resultado = it }
        }
        return resultado

    }


    private fun alteraCorDoCirculo(resultado: String?){

        val circle = findViewById<ImageView>(R.id.ic_circle)

        when (resultado) {
            "low" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.low_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            "normal" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.normal_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            "high" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.high_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            "obesity1" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.obesity_1_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            "obesity2" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.obesity_2_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            "obesity3" -> {
                circle.setColorFilter(ContextCompat.getColor(this, R.color.obesity_3_weight), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }

    }


}



