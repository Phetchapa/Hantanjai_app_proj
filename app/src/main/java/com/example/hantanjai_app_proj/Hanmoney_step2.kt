package com.example.hantanjai_app_proj

import android.os.Bundle
import android.view.View.OnFocusChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar


class Hanmoney_step2 : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var navbarback: ImageView? = null
    var navbaredit: EditText? = null
    var btnconfirm: Button? = null

    var friendName = arrayOf(
        "Seulgi",
        "Winter",
        "Papaya salad",
        "Jisoo",
        "Irene",
        "Jennie",
        "Seulgi",
        "Winter",
        "Papaya salad",
        "Jisoo",
        "Irene",
        "Jennie",
        "Wonyong"
    )

    var userProfile = arrayOf<Int>(
        R.drawable.flower01,
        R.drawable.flower02,
        R.drawable.flower03,
        R.drawable.flower04,
        R.drawable.flower05,
        R.drawable.flower06,
        R.drawable.flower01,
        R.drawable.flower02,
        R.drawable.flower03,
        R.drawable.flower04,
        R.drawable.flower05,
        R.drawable.flower06,
        R.drawable.flower07
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step2)
        init()

        val calendar = Calendar.getInstance()
        val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)

        val textViewDate = findViewById<TextView>(R.id.step2datecurent)
        textViewDate.text = currentDate

        val myAdapter = MyAdapterstep2(friendName,userProfile)
        recyclerView!!.adapter=myAdapter
        btnconfirm!!.setOnClickListener {
            Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
        }


    }
    fun init(){
        recyclerView = findViewById(R.id.recycleviewstep2)
        navbarback = findViewById(R.id.navbarstep2back)
        navbaredit = findViewById(R.id.navbarstep2edt)
        btnconfirm = findViewById(R.id.step2btnconfirm)
    }
}

