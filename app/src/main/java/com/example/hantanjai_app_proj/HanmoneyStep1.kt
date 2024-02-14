package com.example.hantanjai_app_proj

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HanmoneyStep1 : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var step1btnconfirm: Button? = null

    var friendName = arrayOf(
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
        R.drawable.flower07
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanmoney_step_one)
        init()

        val myAdapterForHanStepOne = MyAdapterForHanStepOne(friendName, userProfile)
        recyclerView!!.adapter = myAdapterForHanStepOne

        step1btnconfirm?.setOnClickListener {
            val selectedIndices = myAdapterForHanStepOne.getSelectedIndices()

            // Filter arrays based on selected indices
            val selectedFriendNames = selectedIndices.map { friendName[it] }.toTypedArray()
            val selectedUserProfiles = selectedIndices.map { userProfile[it] }.toTypedArray()

            // Pass the filtered arrays to the next activity
            val intent = Intent(this, Hanmoney_step2::class.java)
            intent.putExtra("selectedFriendNames", selectedFriendNames)
            intent.putExtra("selectedUserProfiles", selectedUserProfiles)

            // Start the next activity
            startActivity(intent)
            finish()
        }
    }

    fun init(){
        recyclerView = findViewById(R.id.recycler_view)
        step1btnconfirm = findViewById(R.id.step1btnconfirm)
    }

}