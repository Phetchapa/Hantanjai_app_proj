package com.example.hantanjai_app_proj

import android.content.Intent
import android.os.Bundle
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

    var selectedFriendNames: Array<String>? = null
    var selectedUserProfiles: IntArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step2)
        init()
        navbarback?.setOnClickListener {

            val intent = Intent(this, HanmoneyStep1::class.java)


            // Start the next activity
            startActivity(intent)
            finish()
        }

        // Retrieve the selectedFriendNames and selectedUserProfiles from the intent
        selectedFriendNames = intent.getStringArrayExtra("selectedFriendNames")
        selectedUserProfiles = intent.getIntArrayExtra("selectedUserProfiles")

        if (selectedFriendNames != null && selectedUserProfiles != null) {
            val calendar = Calendar.getInstance()
            val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)

            val textViewDate = findViewById<TextView>(R.id.step2datecurent)
            textViewDate.text = currentDate

            val myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!)
            recyclerView!!.adapter = myAdapter

            btnconfirm!!.setOnClickListener {
                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
            }
        } else {
            // Handle the case where intent extras are null
            Toast.makeText(this, "Error: Intent extras are null", Toast.LENGTH_LONG).show()
            finish() // Finish the activity or handle the error accordingly
        }

//        val calendar = Calendar.getInstance()
//        val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
//
//        val textViewDate = findViewById<TextView>(R.id.step2datecurent)
//        textViewDate.text = currentDate
//
//        val myAdapter = MyAdapterstep2(selectedFriendNames,selectedUserProfiles)
//        recyclerView!!.adapter=myAdapter
//        btnconfirm!!.setOnClickListener {
//            Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
//        }

    }
    fun init(){
        recyclerView = findViewById(R.id.recycleviewstep2)
        navbarback = findViewById(R.id.navbarstep2back)
        navbaredit = findViewById(R.id.navbarstep2edt)
        btnconfirm = findViewById(R.id.step2btnconfirm)
    }
}

