//package com.example.hantanjai_app_proj
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.RadioButton
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import java.text.SimpleDateFormat
//import java.util.Calendar
//
//
//class Hanmoney_step2 : AppCompatActivity() {
//    var recyclerView: RecyclerView? = null
//    var navbarback: ImageView? = null
//    var navbaredit: EditText? = null
//    var btnconfirm: Button? = null
//    var radiohanequl: RadioButton? = null
//    var radiohanunequl: RadioButton? = null
//
//    var recyclerView2: RecyclerView? = null
//    private var editTextValues: MutableList<String?> = mutableListOf()
//    var selectedFriendNames: Array<String>? = null
//    var selectedUserProfiles: IntArray? = null
//        override fun onCreate(savedInstanceState: Bundle?) {
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
//
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
//            val myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!)
//            recyclerView!!.adapter = myAdapter
//
//
//            // Now editTextValues contains the updated values
//            Toast.makeText(this, "Values: $editTextValues", Toast.LENGTH_LONG).show()
//            btnconfirm!!.setOnClickListener {
//                Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
//
//            }
//        } else {
//            // Handle the case where intent extras are null
//            Toast.makeText(this, "Error: Intent extras are null", Toast.LENGTH_LONG).show()
//            finish() // Finish the activity or handle the error accordingly
//        }
//
//        radiohanequl!!.setOnClickListener {
//            val han1myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!)
//            recyclerView2!!.adapter = han1myAdapter
//
//
//            // Now editTextValues contains the updated values
//            Toast.makeText(this, "Values: $editTextValues", Toast.LENGTH_LONG).show()
//        }
//        radiohanunequl!!.setOnClickListener {
//            val han2myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!)
//            recyclerView2!!.adapter = han2myAdapter
//        }
//
//
//    }
////override fun onCreate(savedInstanceState: Bundle?) {
////    super.onCreate(savedInstanceState)
////    setContentView(R.layout.activity_hanmoney_step2)
////    init()
////    navbarback?.setOnClickListener {
////        val intent = Intent(this, HanmoneyStep1::class.java)
////        startActivity(intent)
////        finish()
////    }
////
////    selectedFriendNames = intent.getStringArrayExtra("selectedFriendNames")
////    selectedUserProfiles = intent.getIntArrayExtra("selectedUserProfiles")
////
////    if (selectedFriendNames != null && selectedUserProfiles != null) {
////        val calendar = Calendar.getInstance()
////        val currentDate = SimpleDateFormat("dd/MM/yyyy").format(calendar.time)
////        val textViewDate = findViewById<TextView>(R.id.step2datecurent)
////        textViewDate.text = currentDate
////
////        // Pass editTextValues to MyAdapterstep2
////        val myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!, editTextValues)
////        recyclerView!!.adapter = myAdapter
////
////        btnconfirm!!.setOnClickListener {
////            Toast.makeText(this, "Values: $editTextValues", Toast.LENGTH_LONG).show()
////        }
////    } else {
////        Toast.makeText(this, "Error: Intent extras are null", Toast.LENGTH_LONG).show()
////        finish()
////    }
////
////    radiohanequl!!.setOnClickListener {
////        val han1myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!, editTextValues)
////        recyclerView2!!.adapter = han1myAdapter
////        Toast.makeText(this, "Values: $editTextValues", Toast.LENGTH_LONG).show()
////    }
////
////    radiohanunequl!!.setOnClickListener {
////        val han2myAdapter = MyAdapterstep2(selectedFriendNames!!, selectedUserProfiles!!, editTextValues)
////        recyclerView2!!.adapter = han2myAdapter
////    }
//}
//    fun init(){
//        recyclerView = findViewById(R.id.recycleviewstep2)
//        recyclerView2 = findViewById(R.id.hanrecycleviewstep2)
//        navbarback = findViewById(R.id.navbarstep2back)
//        navbaredit = findViewById(R.id.navbarstep2edt)
//        btnconfirm = findViewById(R.id.step2btnconfirm)
//        radiohanequl = findViewById(R.id.hanequl_layout)
//        radiohanunequl = findViewById(R.id.hanunequl_layout)
//    }
//}
//
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

            // Pass editTextValues to MyAdapterstep2
            val myAdapter = MyAdapterstep2(
                selectedFriendNames!!.toList(),
                selectedUserProfiles!!.toList(),
                editTextValues
            ) { updatedValues ->
                editTextValues = updatedValues.toMutableList()
            }


            recyclerView!!.adapter = myAdapter
//            radiohanequl!!.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//
////                    recyclerView2?.visibility = View.VISIBLE
//
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
//
//                    // Calculate total based on editTextValues and display in showtotal TextView
//                    val total = editTextValues
//                        .filterNotNull()
//                        .map { it.toDoubleOrNull() ?: 0.0 }
//                        .sum()
//
//                    showtotal?.text = "$total ฿"
//                } else {
//                    // Hide recyclerView2 when radiohanunequl is not checked
////                    recyclerView2?.visibility = View.GONE
//                }
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

                    // Update recyclerView adapter with the new values
                    recyclerView!!.adapter?.notifyDataSetChanged()

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

                // Display a Toast message with the total value
//                Toast.makeText(this, "Total: $total ฿", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Total: $total ฿\nMembers: ${editTextValues.joinToString(", ")}", Toast.LENGTH_LONG).show()

                // Create an Intent to start the HomeActivity
                val intent = Intent(this, MainActivity::class.java)

                // Pass the necessary data to the next activity
                intent.putExtra("totalValue", total)
                intent.putExtra("editTextValues", editTextValues.toTypedArray())

                // Start the next activity
                startActivity(intent)
                finish() // Finish the current activity
            }

//            btnconfirm!!.setOnClickListener {
//                val total = editTextValues
//                    .filterNotNull()
//                    .map { it.toDoubleOrNull() ?: 0.0 } // Convert String values to Double, default to 0.0 if conversion fails
//                    .sum()
//
//                showtotal?.text = "$total ฿"
//            }
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


//        radiohanequl!!.setOnClickListener {
//        val han1myAdapter = MyAdapterstep2(selectedFriendNames!!.toList(), selectedUserProfiles!!.toList())
//        recyclerView2!!.adapter = han1myAdapter
//    }
//
//    radiohanunequl!!.setOnClickListener {
//        val han2myAdapter = MyAdapterstep2(selectedFriendNames!!.toList(), selectedUserProfiles!!.toList())
//        recyclerView2!!.adapter = han2myAdapter
//    }
