package com.ramonbarros.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.math.BigInteger
import kotlin.Exception
import kotlin.math.pow

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
    var mathError: Boolean = false;

    fun resetDisplay() {
        if (isResult) {
            tvDisplayCalc.text = tvDisplayResult.text
            displayFormula = tvDisplayResult.text.toString()
            displayOutput = tvDisplayResult.text.toString()
            displayText = tvDisplayResult.text.toString()
            tvDisplayResult.text = "0"
            isResult = false
        }
    }

    fun buttonClicked(view: View) {
        resetDisplay()
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

    fun showResult(formulaInput: String): String {
        Log.e( "Actual","formula is $formulaInput")
        return calculateResult(formulaInput)
    }

    fun calculateResult(displayFormula: String):String{
        var substitute = displayFormula
        var isOperation = true
        substitute = insertMultiplySign(substitute)
        substitute = changePiEuler(substitute)
        while (isOperation) {
            substitute = resolveComplexOperations(substitute)
            substitute = solveParenthesis(substitute)
            substitute = solveOperations(substitute)
            if (substitute.matches("-?\\d*\\.*\\d+?".toRegex())) {
                isOperation = false
            }
        }
        println(substitute.toDouble())
        return substitute.toDouble().toString()
    }

    fun solveOperations(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf(
                "(-?\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)", // x^y case 0
                "(-?\\d*\\.*\\d+?)\\/(-?\\d+\\.*\\d*)", // x/y case 1
                "(-?\\d*\\.*\\d+?)\\*(-?\\d+\\.*\\d*)", // x*y case 2
                "(-?\\d*\\.*\\d+?)\\+(-?\\d+\\.*\\d*)", // x+y case 3
                "(-?\\d*\\.*\\d+?)\\-(-?\\d+\\.*\\d*)" // x-y case 4
        )

        for (i in arrayOfPattern.indices) {
            val pattern = Regex(arrayOfPattern[i])
            val matches = pattern.findAll(substitute).iterator()
            var a: Double;
            var b: Double;
            while (matches.hasNext()) {
                try {
                    val match = matches.next()
                    val operation = match.groupValues[0]
                    println(operation)
                    a = match.groupValues[1].toDouble()
                    b = match.groupValues[2].toDouble()
                    println("Estamos olhando dentro de $operation")
                } catch (e: Exception) {
                    break
                }
                when (i) {
                    0 -> substitute = substitute.replace(pattern, a.pow(b).toBigDecimal().toPlainString())
                    1 -> substitute = substitute.replace(pattern, a.div(b).toBigDecimal().toPlainString())
                    2 -> substitute = substitute.replace(pattern, a.times(b).toBigDecimal().toPlainString())
                    3 -> substitute = substitute.replace(pattern, a.plus(b).toBigDecimal().toPlainString())
                    4 -> substitute = substitute.replace(pattern, a.minus(b).toBigDecimal().toPlainString())
                }
                println("Nova string é: $substitute")
            }
        }
        return substitute
    }

    fun solveParenthesis(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf("\\((.+)\\)")
        for (i in arrayOfPattern.indices) {
            val pattern = Regex(arrayOfPattern[i])
            val matches = pattern.findAll(substitute).iterator()
            while (matches.hasNext()) {
                val match = matches.next()
                var op_substitute = match.groupValues[1]
                println("Olhando dentro da  $op_substitute")
                op_substitute = solveOperations(op_substitute)
                substitute = substitute.replace(pattern, "($op_substitute)")
            }
        }
        return substitute
    }

    fun changePiEuler(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf("(Math.E\\(\\))", "(Math.PI\\(\\))") // "Math.E()", "Math.PI"

        for (i in arrayOfPattern.indices) {
            println("Pattern usado é " + arrayOfPattern[i])
            val pattern = Regex(arrayOfPattern[i])
            val matches = pattern.findAll(substitute).iterator()
            while (matches.hasNext()) {
                val match = matches.next()
                when (i) {
                    0 -> substitute = substitute.replace(pattern, Math.E.toString())
                    1 -> substitute = substitute.replace(pattern, Math.PI.toString())
                }
            }
        }
        return substitute
    }

    fun resolveComplexOperations(args: String): String {
        var substitute = args
        val arrayOfPattern: Array<String> = arrayOf(
                "(sin\\((-?\\d*\\.*\\d+?)\\))", "(cos\\((-?\\d*\\.*\\d+?)\\))", // sin(n); cos(n)
                "(tan\\((-?\\d*\\.*\\d+?)\\))", "(ln\\((-?\\d*\\.*\\d+?)\\))",  // tan(n); ln(n)
                "(log\\((-?\\d*\\.*\\d+?)\\))", "(sec\\((-?\\d*\\.*\\d+?)\\))", // log(n); sec(n)
                "(csc\\((-?\\d*\\.*\\d+?)\\))", "(ctn\\((-?\\d*\\.*\\d+?)\\))", // cosec(n), cotan(n)
                "(sqrt\\((-?\\d*\\.*\\d+?)\\))", "(module\\((-?\\d*\\.*\\d+?)\\))", // sqrt(n), mod(n)
                "(factorial\\((-?\\d*\\.*\\d+?)\\))", "(inverseValue\\((-?\\d*\\.*\\d+?)\\))", // fact(n), Inv(n)
                "(changeSign\\((-?\\d*\\.*\\d+?)\\))" // +/-(n)
                        )

        for (i in arrayOfPattern.indices) {
            val patt_i = arrayOfPattern[i]
            println("Pattern usado é $patt_i")
            val pattern = Regex(arrayOfPattern[i])
            val matches = pattern.findAll(substitute).iterator()
            var number: Double
            while (matches.hasNext()) {
                val match = matches.next()
                try {
                    number = match.groupValues[2].toDouble()
                } catch (e:NumberFormatException) {
                    break
                }
                println("O valor da match é $number")
                when (i) {
                    0 -> substitute = substitute.replace(pattern, kotlin.math.sin(number).toBigDecimal().toPlainString());
                    1 -> substitute = substitute.replace(pattern, kotlin.math.cos(number).toBigDecimal().toPlainString());
                    2 -> substitute = substitute.replace(pattern, kotlin.math.tan(number).toBigDecimal().toPlainString());
                    3 -> substitute = substitute.replace(pattern, kotlin.math.ln(number).toBigDecimal().toPlainString());
                    4 -> substitute = substitute.replace(pattern, kotlin.math.log10(number).toBigDecimal().toPlainString());
                    5 -> substitute = substitute.replace(pattern, (1/kotlin.math.cos(number)).toBigDecimal().toPlainString()); //secant = 1/cos(x)
                    6 -> substitute = substitute.replace(pattern, (1/kotlin.math.sin(number)).toBigDecimal().toPlainString()); // cossecant = 1/sin(x)
                    7 -> substitute = substitute.replace(pattern, (1/kotlin.math.tan(number)).toBigDecimal().toPlainString()); // cotangent = 1/tan(x)
                    8 -> substitute = substitute.replace(pattern, kotlin.math.sqrt(number).toBigDecimal().toPlainString());
                    9 -> substitute = substitute.replace(pattern, kotlin.math.abs(number).toBigDecimal().toPlainString())
                    10 -> substitute = substitute.replace(pattern, factorial(number.toLong()).toString())
                    11 -> substitute = substitute.replace(pattern, (1/number).toBigDecimal().toPlainString()) // Inverse(n)
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
            else if (input == "-/+"){ return "changeSign(" }
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
                "(-?\\d*\\.*\\d+?\\()", // "1.0("
                "(\\)\\d*\\.*\\d+?)", // ")1.0"
                "(\\))(\\()", //")("
                // "(\\()(\\()", //"(("
                "([A-z])([0-9])", // a8
                "(-?\\d*\\.*\\d+?)([A-z])", //8a -8a
                "(\\))([A-z])" // )log
        )

        for (i in arrayOfPattern) {
            println("Pattern usado é $i")
            val pattern = Regex(i)
            val matches = pattern.findAll(substitute).iterator()
            while (matches.hasNext()) {
                val match = matches.next()
                val a = match.groupValues[1]
                val b = match.groupValues[2]
                if (a == "^" || b == "^"){
                    break
                } else {
                    substitute = substitute.replace(pattern, "$1" + "*" + "$2")
                    println("Conseguimos o seguinte resultado " + match.value)
                    println("Nova string é: $substitute")
                }
            }
        }
        return substitute
    }
}
