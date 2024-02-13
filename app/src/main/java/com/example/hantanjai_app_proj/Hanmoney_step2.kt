package com.example.hantanjai_app_proj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import java.text.SimpleDateFormat
import java.util.Calendar

class Hanmoney_step2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step2)

        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)

        val textViewDate = findViewById<TextView>(R.id.step2datecurent)
        textViewDate.text = currentDate
    }
}