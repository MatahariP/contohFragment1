package com.example.contohfragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class InputFragment : DialogFragment(), View.OnClickListener {
    private var etText: EditText? = null
    private var btnShowText: Button? = null

    var onOptionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_radio_button, container, false)
        etText = view.findViewById<View>(R.id.et_text) as EditText
        btnShowText = view.findViewById<View>(R.id.btn_show_text) as Button
        btnShowText!!.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View) {
       if (v.id == R.id.btn_show_text) {
            val textToShow = etText?.text.toString()
            onOptionDialogListener?.onOptionChoosen(textToShow)
           etText?.setText("")
            dismiss()
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChoosen(text: String?)
    }
}
