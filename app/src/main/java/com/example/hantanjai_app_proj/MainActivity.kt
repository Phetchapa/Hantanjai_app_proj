package com.example.hantanjai_app_proj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.hantanjai_app_proj.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        replaceFragment(Home())
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar_layout)
        val actionBarTextView: AppCompatTextView = supportActionBar?.customView?.findViewById(R.id.action_bar)
            ?: throw IllegalStateException("action_bar TextView not found in custom ActionBar layout")

        // Update the text of the TextView
        actionBarTextView.text = "New ActionBar Title"

        replaceFragment(Home())



        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.notification -> replaceFragment(Notification())
                R.id.other -> replaceFragment(Other())
                R.id.pay_bill -> replaceFragment(Paybill())

                else -> {

                }

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout,fragment)
        fragmentTransition.commit()
    }
}

