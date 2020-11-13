package com.ramonbarros.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*// number 0 to 9 pressed
        button_0.setOnClickListener() {
            val digit = button_0.text.toString()
            val formulaDigit = button_0.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_1.setOnClickListener() {
            val digit = button_1.text.toString()
            val formulaDigit = button_1.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_2.setOnClickListener() {
            val digit = button_2.text.toString()
            val formulaDigit = button_2.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_3.setOnClickListener() {
            val digit = button_3.text.toString()
            val formulaDigit = button_3.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_4.setOnClickListener() {
            val digit = button_4.text.toString()
            val formulaDigit = button_4.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_5.setOnClickListener() {
            val digit = button_5.text.toString()
            val formulaDigit = button_5.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_6.setOnClickListener() {
            val digit = button_6.text.toString()
            val formulaDigit = button_6.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_7.setOnClickListener() {
            val digit = button_7.text.toString()
            val formulaDigit = button_7.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_8.setOnClickListener() {
            val digit = button_8.text.toString()
            val formulaDigit = button_8.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_9.setOnClickListener() {
            val digit = button_9.text.toString()
            val formulaDigit = button_9.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        // Basic Operation Buttons

        button_sum.setOnClickListener(){
            val digit = button_sum.text.toString()
            val formulaDigit = button_sum.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_subtraction.setOnClickListener(){
            val digit = button_sum.text.toString()
            val formulaDigit = button_sum.text.toString()
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_division.setOnClickListener(){
            val digit = button_sum.text.toString()
            val formulaDigit = '/'
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }

        button_multiplication.setOnClickListener(){
            val digit = button_sum.text.toString()
            val formulaDigit = '*'
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, digit, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaDigit, isMaxCharacter) // update display string and checks max character
            buttonClicked(isMaxCharacter, digit, formulaDigit, displayText) // do the next steps, refer to it
        }*/

    }

    var isResult = false;
    val maxCharacters: Int = 28
    var displayText: String = "";
    var displayFormula: String = "";
    var isMaxCharacter: Boolean = false;
    var formulaInput: String = ""
    var displayOutput: String = ""

    fun buttonClicked(view: View) {
        val button = view as Button
        val input = button.text.toString()
        if (input == "=") {
            isResult = true
            tvDisplayResult.text = showResult(displayFormula)
        } else {
            displayOutput =  changeToOutputOrFormula(input, false) // change the keyboard input to be shown in calculator display
            formulaInput = changeToOutputOrFormula(input, true) // change the keyboard input to a formula input
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // update if maxCharacter is fulfilled
            displayText = buttonToString(displayText, displayOutput, isMaxCharacter) // update display string and checks max character
            displayFormula = buttonToFormula(displayFormula, formulaInput, isMaxCharacter) // update display string and checks max character
            refreshDisplay(displayText, isMaxCharacter)
            Log.i("teste", "O botão com texto $input foi clicado")
        }
    }

    fun showResult(formulaInput: String):String {
        Log.e( "Actual","formula is $formulaInput")
        calculateResult(formulaInput)
        return ""
    }
    fun calculateResult(displayFormula: String):Long{
        var substitute = ""
        substitute = insertMultiplySign(displayFormula)
        substitute = changePiEuler(substitute)
        substitute = resolveTrigonometricAndLogarithm(substitute)
        return 0
    }

    fun changePiEuler(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf("(Math.E\\(\\))", "(Math.PI\\(\\))") // "Math.E()", "Math.PI"

        for (i in arrayOfPattern) {
            println("Pattern usado é $i")
            val pattern = Regex(i)
            val matches = pattern.findAll(substitute).iterator()
            if (i == "Math.E\\(\\)") {
                while (matches.hasNext()) {
                    val match = matches.next()
                    substitute = substitute.replace(pattern, Math.E.toString())
                    println("Conseguimos o seguinte resultado " + match.value)
                    println("Nova string é: $substitute")
                }
            } else {
                while (matches.hasNext()) {
                    val match = matches.next()
                    substitute = substitute.replace(pattern, Math.PI.toString())
                    println("Conseguimos o seguinte resultado " + match.value)
                    println("Nova string é: $substitute")
                }
            }
        }
        return substitute
    }

    fun resolveTrigonometricAndLogarithm(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf(
                "(sin\\(([0-9]+\\.*[0-9]*)\\))", "(cos\\(([0-9]+\\.*[0-9]*)\\))", // sin(n); cos(n)
                "(tan\\(([0-9]+\\.*[0-9]*)\\))", "(ln\\(([0-9]+\\.*[0-9]*)\\))",  // tan(n); ln(n)
                "(log\\(([0-9]+\\.*[0-9]*)\\))", "(sec\\(([0-9]+\\.*[0-9]*)\\))", // log(n); sec(n)
                "(csc\\(([0-9]+\\.*[0-9]*)\\))", "(ctn\\(([0-9]+\\.*[0-9]*)\\))" // cosec(n), cotan(n)
        )

        for (i in arrayOfPattern.indices) {
            val pati = arrayOfPattern[i]
            println("Pattern usado é $pati")
            val pattern = Regex(arrayOfPattern[i])
            val matches = pattern.findAll(substitute).iterator()
            while (matches.hasNext()) {
                val match = matches.next()
                val number = match.groupValues[2].toDouble()
                println("O valor da match é $number")
                when (i) {
                    0 -> substitute = substitute.replace(pattern, kotlin.math.sin(number).toString())
                    1 -> substitute = substitute.replace(pattern, kotlin.math.cos(number).toString());
                    2 -> substitute = substitute.replace(pattern, kotlin.math.tan(number).toString());
                    3 -> substitute = substitute.replace(pattern, kotlin.math.ln(number).toString());
                    4 -> substitute = substitute.replace(pattern, kotlin.math.log10(number).toString());
                    5 -> substitute = substitute.replace(pattern, (1/kotlin.math.cos(number)).toString()); //secant = 1/cos(x)
                    6 -> substitute = substitute.replace(pattern, (1/kotlin.math.sin(number)).toString()); // cossecant = 1/sin(x)
                    7 -> substitute = substitute.replace(pattern, (1/kotlin.math.tan(number)).toString()); // cotangent = 1/tan(x)
                }

                println("Conseguimos o seguinte resultado " + match.value)
                println("Nova string é: $substitute")
            }
        }
        return substitute
    }


    fun changeToOutputOrFormula(input: String, isFormula: Boolean): String {
        if (isFormula) {
            if (input.isDigitsOnly() || input in arrayOf("+", "-", "%", "(", ")", ".") ){ return input }
            else if (input in arrayOf("sin", "cos", "tan", "ln", "log", "sec", "csc", "ctn")){ return "$input(" }
            else if (input == "÷"){ return "/" }
            else if (input == "×"){ return "*" }
            else if (input == "e"){ return "Math.E()" }
            else if (input == "π"){ return "Math.PI()" }
            else if (input == "x!"){ return "factorial(" }
            else if (input == "√"){ return "sqrt(" }
            else if (input == "x^y"){ return "^" }
            else if (input == "x^2"){ return "^2" }
            else if (input == "Inv"){ return "inverseValue(" }
            else if (input == "|x|"){ return "module(" }
            else if (input == "-/+"){ return "inverseValue(" }
            return " "
            } else {
            if (input.isDigitsOnly() || input in arrayOf("+", "-", "%", "(", ")", ".", "÷", "×", "e", "π") ){ return input }
            else if (input in arrayOf("sin", "cos", "tan", "ln", "log", "sec", "cosec", "cotan")){ return "$input(" }
            else if (input == "x!"){ return "fact(" }
            else if (input == "√"){ return "sqrt(" }
            else if (input == "x^y"){ return "^" }
            else if (input == "x^2"){ return "^2" }
            else if (input == "Inv"){ return "Inv(" }
            else if (input == "|x|"){ return "mod(" }
            return " "
        }
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
        Log.e( "Actual","actual formula is $actual, newString is $newString")
        return newString
    }

    fun refreshDisplay(text: String, isMaxCharacter: Boolean){
        //Log.e("Actual", "The display must show $text")
        if (!isMaxCharacter) {
            if (text == "") {
                tvDisplayCalc.text = "0"
            } else {
                tvDisplayCalc.text = text
            }
        }
    }

    // Helpers
    fun checkIsMaxCharacters(text: String, maxCharacters: Int): Boolean{
        return text.length + 1 >= maxCharacters
    }

    fun factorial(args: Long): Any {
        val x = args.toInt()
        var result = 1
        for (i in 1..x) {
            result = result * i
        }
        return result
    }

    fun insertMultiplySign(displayFormula: String): String {
        // Add the multiply sign where there's no math operator
        var substitute = displayFormula
        val arrayOfPattern: Array<String> = arrayOf(
                "([0-9]+\\.*[0-9]*)(\\()", // "1.0("
                "(\\))([0-9]+\\.*[0-9]+)", // ")1.0"
                // "([A-z])(\\()", // "A("
                "(\\))([A-z])", // )A"
                "(\\))(\\()", //")("
                "(\\()(\\()", //"(("
                "([A-z])([0-9])", // a8
                "([0-9])([A-z])", //8a
                "(\\))([A-z])" // )log
        )

        for (i in arrayOfPattern) {
            println("Pattern usado é $i")
            val pattern = Regex(i)
            val matches = pattern.findAll(substitute).iterator()
            while (matches.hasNext()) {
                val match = matches.next()
                substitute = substitute.replace(pattern, "$1"+"*"+"$2")
                println("Conseguimos o seguinte resultado " + match.value)
                println("Nova string é: $substitute")
            }
        }
        return substitute
    }
}