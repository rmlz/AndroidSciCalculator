package com.ramonbarros.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result = false;
        val maxCharacters: Int = 16
        var displayText: String = "";

        fun showGenericObjectName(v: View) {
            if (v is Button){
                tvDisplay.text = (v as Button).text.toString()
            }
        }


        // number 0 to 9 pressed
        button_0.setOnClickListener() {
            val digit: String = button_0.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_1.setOnClickListener() {
            val digit: String = button_1.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_2.setOnClickListener() {
            val digit: String = button_2.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_3.setOnClickListener() {
            val digit: String = button_3.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_4.setOnClickListener() {
            val digit: String = button_4.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_5.setOnClickListener() {
            val digit: String = button_5.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_6.setOnClickListener() {
            val digit: String = button_6.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_7.setOnClickListener() {
            val digit: String = button_7.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_8.setOnClickListener() {
            val digit: String = button_8.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
        button_9.setOnClickListener() {
            val digit: String = button_9.text.toString()
            displayText = numberToString(displayText, digit, maxCharacters)
            refreshDisplay(displayText, maxCharacters)
        }
    }

    fun refreshDisplay(text: String, maxCharacters: Int){
        // Max display characters
        //Log.e("Actual", "The display must show $text")
        if (text.length <= maxCharacters) {
            if (text == "") {
                tvDisplay.text = "0"
            } else {
                tvDisplay.text = text
            }
        }
    }

    fun numberToString(actual:String, new:String, maxCharacters: Int): String {
        val newString: String = actual + new;
        //Log.e("Actual", "Actual is $actual and newString is $newString")
        // Don't update the text if multiple zeroes = 0
        if (newString.toLong() == "0".toLong() || newString.length > maxCharacters) {
            return actual
        }
        return newString
    };

    fun sum() {

    }

    fun divide() {

    }

    fun multiply() {

    }

    fun subtract() {

    }

}