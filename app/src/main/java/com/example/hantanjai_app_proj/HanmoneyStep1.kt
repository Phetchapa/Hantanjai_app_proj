package com.example.hantanjai_app_proj

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HanmoneyStep1 : AppCompatActivity() {

    var recyclerView: RecyclerView? = null

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

        val myAdapter = MyAdapter(friendName,userProfile)
        recyclerView!!.adapter=myAdapter

    }

    fun init(){
        recyclerView = findViewById(R.id.recycler_view)
    }

}