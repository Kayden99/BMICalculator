package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.EnterButton)

        btnEnter.setOnClickListener(){

           val LfName = findViewById<TextView>(R.id.tfName)

            val intent = Intent(this, BMIActivity::class.java)

            intent.putExtra("personName", LfName.text.toString())

            startActivity(intent)
        }



    }
}