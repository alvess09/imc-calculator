package com.example.imccalculator

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class ResutActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resut)
        TODO("criar função que troque as cores do circulo de acordo com o resultado do IMC")
        TODO("criar função que troque o valor de acordo com o resultado do IMC dentro do circulo")
        TODO("criar função que troque as cores do circulo de acordo com o resultado do IMC")
        val result = "low"

        if(result == "low"){
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.low_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        } else if (result = "normal") {
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.normal_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        } else if (result = "high") {
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.high_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        } else if (result = "obesity1") {
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.obesity_1_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        } else if (result = "obesity2") {
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.obesity_2_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        } else if (result = "obesity3") {
            val circle = R.id.ic_cicrcle.setColorFilter(ContextCompat.getColor(context, R.color.obesity_3_weight), android.graphics.PorterDuff.Mode.SRC_IN)
        }



    }


}
