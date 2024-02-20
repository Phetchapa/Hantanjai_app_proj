//package com.example.hantanjai_app_proj
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.RadioButton
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
//import java.text.SimpleDateFormat
//import java.util.Calendar
//
//
//class Hanmoney_step2 : AppCompatActivity() {
//    var recyclerView: RecyclerView? = null
//    var recyclerView2: RecyclerView? = null
//    var navbarback: ImageView? = null
//    var navbaredit: EditText? = null
//    var btnconfirm: Button? = null
//    var radiohanequl: RadioButton? = null
//    var radiohanunequl: RadioButton? = null
//    var showtotal: TextView? = null
//    private var editTextValues: MutableList<String?> = mutableListOf()
//    var selectedFriendNames: Array<String>? = null
//    var selectedUserProfiles: IntArray? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_hanmoney_step2)
//        init()
//        navbarback?.setOnClickListener {
//
//            val intent = Intent(this, HanmoneyStep1::class.java)
//
//
//            // Start the next activity
//            startActivity(intent)
//            finish()
//        }
//
//        // Retrieve the selectedFriendNames and selectedUserProfiles from the intent
//        selectedFriendNames = intent.getStringArrayExtra("selectedFriendNames")
//        selectedUserProfiles = intent.getIntArrayExtra("selectedUserProfiles")
//
//        if (selectedFriendNames != null && selectedUserProfiles != null) {
//            val calendar = Calendar.getInstance()
//            val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
//
//            val textViewDate = findViewById<TextView>(R.id.step2datecurent)
//            textViewDate.text = currentDate
//
//            // Pass editTextValues to MyAdapterstep2
//            val myAdapter = MyAdapterstep2(
//                selectedFriendNames ?: emptyArray(),
//                selectedUserProfiles ?: IntArray(0),
//                editTextValues
//            ) { updatedValues ->
//                editTextValues.clear()
//                editTextValues.addAll(updatedValues)
//            }
//
//
//            recyclerView!!.adapter = myAdapter
//            radiohanequl!!.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Calculate total based on editTextValues
//                    val total = editTextValues
//                        .filterNotNull()
//                        .map { it.toDoubleOrNull() ?: 0.0 }
//                        .sum()
//
//                    // Calculate the equal amount for each person
//                    val equalAmount = total / selectedFriendNames!!.size
//
//                    // Update editTextValues with equal amount for each person
//                    editTextValues = MutableList(selectedFriendNames!!.size) { equalAmount.toString() }
//
//                    // Update recyclerView adapter with the new values
////                    recyclerView!!.adapter?.notifyDataSetChanged()
//
//                    // Display the total amount in showtotal TextView
//                    showtotal?.text = "$total ฿"
//                }
//
//
//            }
//
//            radiohanunequl!!.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Show recyclerView2 when radiohanunequl is checked
//                    recyclerView2?.visibility = View.VISIBLE
//                    // Pass editTextValues to MyAdapterstep2 for recyclerView2
//                    val myAdapter2 = MyAdapterstep2(
//                        selectedFriendNames!!.toList(),
//                        selectedUserProfiles!!.toList(),
//                        editTextValues
//                    ) { updatedValues ->
//                        editTextValues = updatedValues.toMutableList()
//                    }
//
//                    recyclerView2!!.adapter = myAdapter2
//                    val total = editTextValues
//                        .filterNotNull()
//                        .map { it.toDoubleOrNull() ?: 0.0 }
//                        .sum()
//
//                    showtotal?.text = "$total ฿"
//                }else {
//                    // Hide recyclerView2 when radiohanunequl is not checked
//                    recyclerView2?.visibility = View.GONE
//                }
//            }
//            btnconfirm!!.setOnClickListener {
//                // Calculate total based on editTextValues and display in showtotal TextView
//                val total = editTextValues
//                    .filterNotNull()
//                    .map { it.toDoubleOrNull() ?: 0.0 }
//                    .sum()
//
//                // Initialize arrays to store values for namesAndValuesRecycle1 and namesAndValuesRecycle2
//                val namesAndValuesRecycle1Array = mutableListOf<String>()
//                val namesAndValuesRecycle2Array = mutableListOf<Pair<String, Double>>()
//
//                // Display a Toast message with the total value and names of each person in RecyclerView อันแรก
//                selectedFriendNames!!.toList().zip(myAdapter.getEditTextValues()).forEach { (friend, value) ->
//                    val nameAndValue = "$friend to ${value ?: "N/A"}"
//                    namesAndValuesRecycle1Array.add(nameAndValue)
//                }
//
//
//                // Display a Toast message with the names and values of each person in RecyclerView อันที่สอง
//                selectedFriendNames!!.mapIndexed { index, friend ->
//                    val value = editTextValues.getOrNull(index)?.toDoubleOrNull() ?: 0.0
//                    val nameAndValue = "$friend to $value"
//                    namesAndValuesRecycle2Array.add(nameAndValue to value)
//                }
//
//                // Extract friend names from namesAndValuesRecycle2Array
//                val friendNamesFromRecycle2 = namesAndValuesRecycle2Array.map { it.first }
//
//                // Convert friendNamesFromRecycle2 to Array
//                val namesAndValuesRecycle2NamesArray = friendNamesFromRecycle2.toTypedArray()
//
//                // Display both Toast messages
//                Toast.makeText(
//                    this,
//                    "Total: $total ฿\nคนออกเงิน: ${namesAndValuesRecycle1Array.joinToString(", ")}\nเงินที่แต่ละคนต้องจ่ายในบิล: ${
//                        namesAndValuesRecycle2NamesArray.joinToString(", ")
//                    }",
//                    Toast.LENGTH_LONG
//                ).show()
//
//                // Create an Intent to start the HomeActivity
//                val intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("totalValue", total)
//                intent.putExtra("editTextValues", editTextValues.toTypedArray())
//                intent.putExtra("namesAndValuesRecycle1", namesAndValuesRecycle1Array.toTypedArray())
//                intent.putExtra("namesAndValuesRecycle2", namesAndValuesRecycle2Array.toTypedArray()) // นี่คือการส่งข้อมูล namesAndValuesRecycle2Array ไปยัง Activity ต่อไป
//                startActivity(intent)
//                finish() // Finish the current activity
//            }
//        } else {
//            Toast.makeText(this, "Error: Intent extras are null", Toast.LENGTH_LONG).show()
//            finish()
//        }
//    }
//    fun init(){
//        recyclerView = findViewById(R.id.recycleviewstep2)
//        recyclerView2 = findViewById(R.id.hanrecycleviewstep2)
//        navbarback = findViewById(R.id.navbarstep2back)
//        navbaredit = findViewById(R.id.navbarstep2edt)
//        btnconfirm = findViewById(R.id.step2btnconfirm)
//        radiohanequl = findViewById(R.id.hanequl_layout)
//        radiohanunequl = findViewById(R.id.hanunequl_layout)
//        showtotal = findViewById(R.id.step2calall)
//
//
//    }
//}
//
//
//
package com.example.hantanjai_app_proj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar


class Hanmoney_step2 : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var recyclerView2: RecyclerView? = null
    var navbarback: ImageView? = null
    var navbaredit: EditText? = null
    var btnconfirm: Button? = null
    var radiohanequl: RadioButton? = null
    var radiohanunequl: RadioButton? = null
    var showtotal: TextView? = null
    private var editTextValues: MutableList<String?> = mutableListOf()
    var selectedFriendNames: Array<String>? = null
    var selectedUserProfiles: IntArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step2)
        init()
        getSupportActionBar()?.hide()
        navbarback?.setOnClickListener {
            val intent = Intent(this, HanmoneyStep1::class.java)
            startActivity(intent)
            finish()
        }
        selectedFriendNames = intent.getStringArrayExtra("selectedFriendNames")
        selectedUserProfiles = intent.getIntArrayExtra("selectedUserProfiles")

        if (selectedFriendNames != null && selectedUserProfiles != null) {
            val calendar = Calendar.getInstance()
            val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
            val textViewDate = findViewById<TextView>(R.id.step2datecurent)
            textViewDate.text = currentDate
            val myAdapter = MyAdapterstep2(
                selectedFriendNames!!.toList(),
                selectedUserProfiles!!.toList(),
                editTextValues
            ) { updatedValues ->
                editTextValues = updatedValues.toMutableList()
            }
            recyclerView!!.adapter = myAdapter
            radiohanequl!!.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Calculate total based on editTextValues
                    val total = editTextValues
                        .filterNotNull()
                        .map { it.toDoubleOrNull() ?: 0.0 }
                        .sum()
                    // Calculate the equal amount for each person
                    val equalAmount = total / selectedFriendNames!!.size
                    // Update editTextValues with equal amount for each person
                    editTextValues = MutableList(selectedFriendNames!!.size) { equalAmount.toString() }
                    // Display the total amount in showtotal TextView
                    showtotal?.text = "$total ฿"
                }
            }
            radiohanunequl!!.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Show recyclerView2 when radiohanunequl is checked
                    recyclerView2?.visibility = View.VISIBLE
                    // Pass editTextValues to MyAdapterstep2 for recyclerView2
                    val myAdapter2 = MyAdapterstep2(
                        selectedFriendNames!!.toList(),
                        selectedUserProfiles!!.toList(),
                        editTextValues
                    ) { updatedValues ->
                        editTextValues = updatedValues.toMutableList()
                    }
                    recyclerView2!!.adapter = myAdapter2
                    val total = editTextValues
                        .filterNotNull()
                        .map { it.toDoubleOrNull() ?: 0.0 }
                        .sum()
                    showtotal?.text = "$total ฿"
                }else {
                    // Hide recyclerView2 when radiohanunequl is not checked
                    recyclerView2?.visibility = View.GONE
                }
            }
            btnconfirm!!.setOnClickListener {
                // Calculate total based on editTextValues and display in showtotal TextView
                val total = editTextValues
                    .filterNotNull()
                    .map { it.toDoubleOrNull() ?: 0.0 }
                    .sum()

                // Display a Toast message with the total value and names of each person in RecyclerView อันแรก
                val namesAndValuesRecycle1 = selectedFriendNames!!.zip(myAdapter.editTextValues)
                    .map { "${it.first}: ${it.second}" }
                    .joinToString(", ")

                // Display a Toast message with the names and values of each person in RecyclerView อันที่สอง
                val namesAndValuesRecycle2 = editTextValues.mapIndexed { index, value ->
                    val personName = selectedFriendNames!![index % selectedFriendNames!!.size]
                    if (value != null) {
                        "$personName: $value"
                    } else {
                        "$personName: N/A"
                    }
                }.joinToString(", ")

                // Display both Toast messages
                Toast.makeText(
                    this,
                    "Total: $total ฿\nMembers Recycle 1: $namesAndValuesRecycle1\nMembers Recycle 2: $namesAndValuesRecycle2",
                    Toast.LENGTH_LONG
                ).show()

                // Create an Intent to start the HomeActivity
                val intent = Intent(this, MainActivity::class.java)

                // Pass the necessary data to the next activity
                intent.putExtra("totalValue", total)
                intent.putExtra("editTextValues", editTextValues.toTypedArray())
                intent.putExtra("namesAndValuesRecycle1", namesAndValuesRecycle1)
                intent.putExtra("namesAndValuesRecycle2", namesAndValuesRecycle2)

                // Start the next activity
                startActivity(intent)
                finish() // Finish the current activity
            }

        } else {
            // Handle the case where intent extras are null
            Toast.makeText(this, "Error: Intent extras are null", Toast.LENGTH_LONG).show()
            finish() // Finish the activity or handle the error accordingly
        }


    }
    fun init(){
        recyclerView = findViewById(R.id.recycleviewstep2)
        recyclerView2 = findViewById(R.id.hanrecycleviewstep2)
        navbarback = findViewById(R.id.navbarstep2back)
        navbaredit = findViewById(R.id.navbarstep2edt)
        btnconfirm = findViewById(R.id.step2btnconfirm)
        radiohanequl = findViewById(R.id.hanequl_layout)
        radiohanunequl = findViewById(R.id.hanunequl_layout)
        showtotal = findViewById(R.id.step2calall)
    }

}
