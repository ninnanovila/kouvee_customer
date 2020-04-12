package com.example.kouveecustomer

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

object CustomView {

    fun successSnackBar(viewInput: View, baseContext: Context, textInput: String){
        val snackBar = Snackbar.make(viewInput,textInput, Snackbar.LENGTH_INDEFINITE)
        snackBar.setActionTextColor(
            ContextCompat.getColor(baseContext, R.color.colorGrey)
        )
        snackBar.setAction("Close"){
            snackBar.dismiss()
        }
        val view = snackBar.view
        view.setBackgroundResource(R.drawable.snack_bar_success)
        val textView = view.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(baseContext, android.R.color.white))
        setTextView(textView)
        snackBar.show()
    }

    fun failedSnackBar(input: View, baseContext: Context, textInput: String){
        val snackBar = Snackbar.make(input, textInput, Snackbar.LENGTH_INDEFINITE)
        snackBar.setActionTextColor(
            ContextCompat.getColor(baseContext, R.color.colorGrey)
        )
        snackBar.setAction("Close"){
            snackBar.dismiss()
        }
        val view = snackBar.view
        view.setBackgroundResource(R.drawable.snack_bar_failed)
        val textView = view.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(baseContext, android.R.color.white))
        setTextView(textView)
        snackBar.show()
    }

    fun warningSnackBar(input: View, baseContext: Context, textInput: String){
        val snackBar = Snackbar.make(input, textInput, Snackbar.LENGTH_INDEFINITE)
        snackBar.setActionTextColor(
            ContextCompat.getColor(baseContext, android.R.color.black)
        )
        snackBar.setAction("Ok"){
            snackBar.dismiss()
        }
        val view = snackBar.view
        view.setBackgroundResource(R.drawable.snack_bar_warning)
        val textView = view.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(baseContext, android.R.color.black))
        setTextView(textView)
        snackBar.show()
    }

    fun welcomeSnackBar(input: View, baseContext: Context, textInput: String){
        val snackBar = Snackbar.make(input, textInput, Snackbar.LENGTH_LONG)
        snackBar.setActionTextColor(
            ContextCompat.getColor(baseContext, android.R.color.white)
        )
        snackBar.setAction("Close"){
            snackBar.dismiss()
        }
        val view = snackBar.view
        view.setBackgroundResource(R.drawable.snack_bar_welcome)
        val textView = view.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(baseContext, android.R.color.white))
        setTextView(textView)
        snackBar.show()
    }

    private fun setTextView(text: TextView){
        text.maxLines = 1
        text.setTypeface(null, Typeface.ITALIC)
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
    }

}