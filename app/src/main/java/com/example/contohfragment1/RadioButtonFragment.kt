package com.example.contohfragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class RadioButtonFragment : DialogFragment(), View.OnClickListener {
    private var btnChoose: Button? = null
    private var btnClose: Button? = null
    private var rgOptions: RadioGroup? = null
    private var rbAwr: RadioButton? = null
    private var rbUnai: RadioButton? = null
    private var rbGeor: RadioButton? = null
    private var rbArteta: RadioButton? = null

    var onOptionDialogListener: OnOptionDialogListener? = null
//    fun setOnOptionDialogListener(onOptionDialogListener: OnOptionDialogListener) {
//        this.onOptionDialogListener = onOptionDialogListener
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_radio_button, container, false)
        btnChoose = view.findViewById<View>(R.id.btn_choose) as Button
        btnChoose!!.setOnClickListener(this)
        btnClose = view.findViewById<View>(R.id.btn_close) as Button
        btnClose!!.setOnClickListener(this)
        rgOptions = view.findViewById<View>(R.id.rg_options) as RadioGroup
        rbAwr = view.findViewById<View>(R.id.rb_awr) as RadioButton
        rbUnai = view.findViewById<View>(R.id.rb_unai) as RadioButton
        rbGeor = view.findViewById<View>(R.id.rb_geor) as RadioButton
        rbArteta = view.findViewById<View>(R.id.rb_arteta) as RadioButton
        return view
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_close) {
            dialog!!.cancel()
        } else if (v.id == R.id.btn_choose) {
            val checkedRadioButtonId = rgOptions!!.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                if (checkedRadioButtonId == R.id.rb_awr) {
                    coach = rbAwr!!.text.toString().trim { it <= ' ' }
                } else if (checkedRadioButtonId == R.id.rb_unai) {
                    coach = rbUnai!!.text.toString().trim { it <= ' ' }
                } else if (checkedRadioButtonId == R.id.rb_geor) {
                    coach = rbGeor!!.text.toString().trim { it <= ' ' }
                } else if (checkedRadioButtonId == R.id.rb_arteta) {
                    coach = rbArteta!!.text.toString().trim { it <= ' ' }
                }
                onOptionDialogListener!!.onOptionChoosen(coach)
                dialog!!.cancel()
            }
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChoosen(text: String?)
    }

}

