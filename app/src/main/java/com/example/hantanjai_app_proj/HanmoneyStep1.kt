package com.example.hantanjai_app_proj

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class HanmoneyStep1 : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var step1btnconfirm: Button? = null
    var card_view_selectAll: CardView?= null


    //Dialog
    var add_new_friend: Button? = null
    //var test_display: TextView? = null
    //End Dialog

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

    //recyclerview
    var myAdapterForHanStepOne = MyAdapterForHanStepOne(friendName, userProfile)

    //Search
    var myList = myAdapterForHanStepOne.getSelectedItems()
    var searchView: SearchView? = null;
    //End Search

    //Dialog
    var newFriendName: String = ""

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step_one)
        init()

        //val myAdapterForHanStepOne = MyAdapterForHanStepOne(friendName, userProfile)
        recyclerView!!.adapter = myAdapterForHanStepOne

        //add new friend's name
        showEditTextdialog()
        //search view
        searchView()
        //select all
        myAdapterForHanStepOne.selectCardAll(card_view_selectAll)

        step1btnconfirm?.setOnClickListener {
            val selectedIndices = myAdapterForHanStepOne.getSelectedIndices()

            // Filter arrays based on selected indices
            val selectedFriendNames = selectedIndices.map { friendName[it] }.toTypedArray()
            val selectedUserProfiles = selectedIndices.map { userProfile[it] }.toIntArray()

            // Pass the filtered arrays to the next activity
            val intent = Intent(this, Hanmoney_step2::class.java)
            intent.putExtra("selectedFriendNames", selectedFriendNames)
            intent.putExtra("selectedUserProfiles", selectedUserProfiles)

            // Start the next activity
            startActivity(intent)
            finish()
        }
    }

    //Dialog
    private fun showEditTextdialog() {
        add_new_friend?.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_layout_hanmoney_step1, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.edt_hs1)

            with(builder) {
                setTitle("เพิ่มรายชื่อ")
                setPositiveButton("ยืนยัน") {dialog, which ->
                    //test_display!!.text = editText.text.toString()
                }
                setNegativeButton("ยกเลิก") {dialog, which ->
                    Log.d("Main","Negative button clicked")
                }
                setView(dialogLayout)
                show()
            }
        }
    }
    //End Dialog

    //Search view
    private fun searchView() {
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {
        if (query != null) {
            // ทำการค้นหาในรายชื่อที่เลือกเท่านั้น
            val filteredList = myAdapterForHanStepOne.getSelectedItems().filter {
                it.first.contains(query, ignoreCase = true)
            }

            // สร้าง Adapter ใหม่พร้อมกับรายการที่ถูกกรอง
//            val filteredAdapter = MyAdapterForHanStepOne(
//                filteredList.map { it.first }.toTypedArray(),
//                filteredList.map { it.second }.toIntArray()
//
//            )

            // แทนที่ Adapter เดิมด้วย Adapter ที่ถูกกรอง
           // recyclerView?.adapter = filteredAdapter
        }
    }



    //End Search view

    fun init(){
        recyclerView = findViewById(R.id.recycler_view)
        step1btnconfirm = findViewById(R.id.step1btnconfirm)
        card_view_selectAll = findViewById(R.id.card_view_selectAll)

        //Dialog
        add_new_friend = findViewById(R.id.btntesths1)
        //test_display = findViewById(R.id.hs1_test_dialog)
        //End Dialog

        //Search view
        searchView = findViewById(R.id.searchview)
        //End Search view
    }

}