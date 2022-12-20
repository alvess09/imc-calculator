package com.example.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.imccalculator.databinding.ActivityResutBinding
import kotlin.math.roundToInt

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityResutBinding
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dados = this.intent.extras
        val peso = dados?.getDouble("peso")
        val altura = dados?.getDouble("altura")

        Log.i("dados","$peso + $altura")

        val imc = calcularImc(peso.toString(), altura.toString())

        val indiceResultado = calculaIndice(imc)

        //configurar a cor do circulo de acordo com o resultado
        alteraCorDoCirculo(indiceResultado)

        val duration =  Toast.LENGTH_SHORT
        Toast.makeText(this, "Seu IMC é considerado: $indiceResultado", duration).show()


    }
    @SuppressLint("SetTextI18n")
    private fun calcularImc(peso: String, altura: String) :Double{

        val pesoConvertido = peso.toDoubleOrNull()
        val alturaConvertida = altura.toDoubleOrNull()
        var imc:Double = 0.0
        val numeroImc = binding.tvResultNumber

        if (pesoConvertido != null && alturaConvertida != null){
            imc = pesoConvertido / (alturaConvertida * alturaConvertida)

            numeroImc.text = "${imc.roundToInt()}"
        }
        return imc
    }

    private fun  calculaIndice(imc:Double):String {
        var indice = " "
        /* menor que 18,5 abaixo do peso ideal
           18,5 a 24,9 peso normal
           25,0 a 29,9 Acima do peso
           30,0 a 34,9 Obesidade classe 1
           35,0 a 39,9 Obesidade classe 2
           imc <= 40,0 Obesidade classe 3
         fonte OMS */

        if (imc <= 18.49) {
            "low".also { indice = it }
        }
        if(imc > 18.5 && imc <= 24.99){
            "normal".also { indice = it }
        }
        if(imc > 25.0 && imc <= 29.99){
            "high".also { indice = it }
        }
        if(imc > 30.0 && imc <= 34.99){
            "obesity1".also { indice = it }
        }
        if(imc > 35.0 && imc <= 39.99){
            "obesity2".also { indice = it }
        }
        if (imc >= 40.0) {
            "obesity3".also { indice = it }
        }
        return indice

    }


    private fun alteraCorDoCirculo(resultado: String?){

        val circle = binding.icCircle

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



