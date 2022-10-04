package com.example.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R.layout.activity_main
import com.santalu.maskara.Mask
import com.santalu.maskara.MaskChangedListener
import com.santalu.maskara.MaskStyle

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val peso: String = findViewById<TextView>(R.id.pesoTXT).toString()
        val altura :String = findViewById<TextView>(R.id.alturaTXT).toString()
        val imc = Imc(peso.toFloat(), altura.toFloat()).apply {
            indice()
            calculoImc(peso.toFloat(), altura.toFloat())
        }

        val mascaraAltura = Mask(
            value = "_,__",
            character = '_',
            style = MaskStyle.COMPLETABLE
        )
        val mascaraPeso = Mask(
            value = "___,__",
            character = '_',
            style = MaskStyle.COMPLETABLE
        )
        val listener = MaskChangedListener(mascaraPeso)
        val listenerAltura = MaskChangedListener(mascaraAltura)
        peso.addTextChangedListener(listener)
        altura.addTextChangedListener(listenerAltura)






        //val calculoImc: String = verificaIndice(imc)


       // val duracao =  Toast.LENGTH_SHORT
        //Toast.makeText(this,calculoImc, duracao).show()

       /* val btnCalcular = findViewById<Button>(R.id.calcularBTN).setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            //passando resultado para activity de resultado
            intent.putExtra("resultadoIndice",calculoImc)
            intent.putExtra("numeroImc",imc.roundToInt())
            startActivity(intent)
        }*/

    }

}








