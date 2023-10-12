package com.example.contohfragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), InputFragment.OnOptionDialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mRadioFragment = InputFragment()
        mRadioFragment.onOptionDialogListener = this

        val btnFragment = findViewById<Button>(R.id.btnFragment)


        btnFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, mRadioFragment)
//                addToBackStack(null)
                commit()
                supportFragmentManager.popBackStack()

            }
        }

    }

    override fun onOptionChoosen(text: String?) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = text
    }
}