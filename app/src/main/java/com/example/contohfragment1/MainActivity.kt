package com.example.contohfragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mRadioFragment = RadioButtonFragment()
        val btnFragment = findViewById<Button>(R.id.btnFragment)

        btnFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, mRadioFragment)
                commit()
            }
        }
    }
}