package com.example.imccalculator

@Suppress("NAME_SHADOWING")
open class Imc(peso: Float, altura: Float) {

    private val imc = calculoImc(peso, altura)


    fun calculoImc(peso:Float, altura:Float):Float{
        return peso / altura * altura
    }

    fun indice():String {
       val imc = this.imc
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


}