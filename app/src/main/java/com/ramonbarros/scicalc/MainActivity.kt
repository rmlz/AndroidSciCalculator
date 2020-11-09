package com.ramonbarros.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result = false;
        val maxCharacters: Int = 25
        var displayText: String = "";
        var displayFormula: String = "";
        var isMaxCharacter: Boolean = false;


        // number 0 to 9 pressed
        button_0.setOnClickListener() {
            val digit = button_0.text.toString()
            val formulaDigit = button_0.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_1.setOnClickListener() {
            val digit = button_1.text.toString()
            val formulaDigit = button_1.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_2.setOnClickListener() {
            val digit = button_2.text.toString()
            val formulaDigit = button_2.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_3.setOnClickListener() {
            val digit = button_3.text.toString()
            val formulaDigit = button_3.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_4.setOnClickListener() {
            val digit = button_4.text.toString()
            val formulaDigit = button_4.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_5.setOnClickListener() {
            val digit = button_5.text.toString()
            val formulaDigit = button_5.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_6.setOnClickListener() {
            val digit = button_6.text.toString()
            val formulaDigit = button_6.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_7.setOnClickListener() {
            val digit = button_7.text.toString()
            val formulaDigit = button_7.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_8.setOnClickListener() {
            val digit = button_8.text.toString()
            val formulaDigit = button_8.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
        button_9.setOnClickListener() {
            val digit = button_9.text.toString()
            val formulaDigit = button_9.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update maxCharacter
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter)
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }
    }
    fun buttonClicked(isMaxCharacter: Boolean, digit: String, formulaDigit: String, displayText:String){
        refreshDisplay(displayText, isMaxCharacter)
    }

    fun buttonToString(actual:String, new:String, isMaxCharacters: Boolean): String {
        val newString: String = actual + new;
        if (isMaxCharacters) {
            return actual
        }
        //Log.e( "Actual","actual is $actual, newString is $newString")
        return newString
    };

    fun buttonToFormula(actual:String, new:String, maxCharacters: Boolean): String {
        val newString: String = actual + new;
        return newString
    }

    fun refreshDisplay(text: String, isMaxCharacter: Boolean){
        // Max display characters
        //Log.e("Actual", "The display must show $text")
        if (!isMaxCharacter) {
            if (text == "") {
                tvDisplayCalc.text = "0"
            } else {
                tvDisplayCalc.text = text
            }
        }
    }



    fun sum() {

    }

    fun divide() {

    }

    fun multiply() {

    }

    fun subtract() {

    }

    // Helpers
    private fun checkIsMaxCharacters(text: String, maxCharacters: Int): Boolean{
        return text.length + 1 >= maxCharacters
    }

}