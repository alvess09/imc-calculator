package com.example.imccalculator

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.imccalculator.R.layout.activity_resut
import java.text.DecimalFormat


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_resut)

        val dados = intent.extras
        val resultadoIndice  = dados?.getString("resultadoIndice")

        val numeroResultadoImc = dados?.getFloat("numeroImc")



        val numeroResultado = findViewById<TextView>(R.id.tv_result_number)
        numeroResultado.text = numeroResultadoImc.toString()

        //configurar a cor do circulo de acordo com o resultado
        alteraCorDoCirculo(resultadoIndice)

        val duration =  Toast.LENGTH_SHORT
        Toast.makeText(this, resultadoIndice, duration).show()


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



