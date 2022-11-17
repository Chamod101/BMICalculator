package com.cdp.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val btnCal = findViewById<Button>(R.id.btnCalculate)

    btnCal.setOnClickListener {
        val weight = weightText.text.toString()
        val height = heightText.text.toString()

        if(validateInput(weight,height)) {

            val BMI = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
            val BMI2Digits = String.format("%.2f", BMI).toFloat()
            showdata(BMI2Digits)
        }
    }

    }

    fun validateInput(weight:String?,height:String?): Boolean {
        return when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this,"Please enter your weight",Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this,"Please enter your height",Toast.LENGTH_SHORT).show()
                return false
            }
            else->{
                return true
            }
        }
    }

    fun showdata(bmi:Float){
        val resultCount = findViewById<TextView>(R.id.tvValue)
        val result = findViewById<TextView>(R.id.tvResult)
        val text = findViewById<TextView>(R.id.tvText)

        resultCount.text = bmi.toString()
        text.text = "Normal range is from 18.5 to 24.9"

        var resultText = ""
        var color = 0

        when{
            bmi<18.50 ->{
                resultText="Under Weight"
                color=R.color.Under_weight
            }
            bmi in 18.50..24.99 ->{
                resultText="Healthy"
                color=R.color.Normal
            }
            bmi in 25.00..29.99 ->{
                resultText="OverWeight"
                color=R.color.Over_weight
            }
            bmi>30 ->{
                resultText="Obese"
                color=R.color.Obese
            }
        }
        result.setTextColor(ContextCompat.getColor(this,color))
        result.text = resultText.toString()
    }
}