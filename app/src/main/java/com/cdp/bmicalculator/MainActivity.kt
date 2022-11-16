package com.cdp.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

        val BMI = weight.toFloat() / ((height.toFloat()/100)*(height.toFloat()/100))
        val BMI2Digits = String.format("%.2f",BMI).toFloat()
        showdata(BMI2Digits)

    }


    }

    fun showdata(bmi:Float){
        val resultCount = findViewById<TextView>(R.id.tvValue)
        val result = findViewById<TextView>(R.id.tvResult)
        val text = findViewById<TextView>(R.id.tvText)

        resultCount.text = bmi.toString()
        text.text = "(Range is between 1.4 - 5)"
    }
}