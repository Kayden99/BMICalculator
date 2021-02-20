package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BMIActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val SName = findViewById<TextView>(R.id.SName)
        val personName = intent?.getStringExtra("personName")
        SName.setText(personName)

        if(savedInstanceState!= null){
           bmiIndex = savedInstanceState.getDouble("bmi")

            val tvStatus = findViewById<TextView>(R.id.LfStatus)
            tvStatus.setText(getStatus())
        }

        val btnCal = findViewById<Button>(R.id.CalButton)
        btnCal.setOnClickListener(){
            val weight = findViewById<TextView>(R.id.tfWeight).text.toString()
            val height = findViewById<TextView>(R.id.tfHeight).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            val tvStatus = findViewById<TextView>(R.id.LfStatus)
            tvStatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmi", bmiIndex)
    }

    fun getStatus() : String{

        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex <= 24.9)
            return "Normal weight"
        else if(bmiIndex <= 29.9)
            return "Overweight"
        else if(bmiIndex <= 34.9)
            return "Obesity Class I"
        else if(bmiIndex <= 39.9)
            return "Obesity Class II"
        else
            return "Obesity CLass III"
    }
}