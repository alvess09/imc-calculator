package com.example.imccalculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_resut

class ResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_resut)



        val textResult = "Este será o resultado!"
        val duration =  Toast.LENGTH_SHORT
        Toast.makeText(this, textResult , duration).show()


    }




        /*
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
         }*/
    }



