package com.ramonbarros.scicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import kotlin.Exception
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplayCalc.movementMethod = ScrollingMovementMethod()
    }

    var isResult = false
    var isMaxCharacter: Boolean = false
    var mathError: Boolean = false
    val maxCharacters: Int = 30
    var displayText: String = ""
    var displayFormula: String = ""
    var formulaInput: String = ""
    var displayOutput: String = ""
    var lastInput: String = ""
    var lastResult = ""
    var calculationHist = emptyArray<String>().toMutableList()


    fun buttonClicked(view: View) {
        resetDisplay()
        val button = view as Button
        val input = button.text.toString()
        if (input == "=") {
            calculateButtonPressed()
            updateHistory()
        } else if (input == "AC") {
            eraseDisplay()
        } else if (input == "\u232B") {
            Log.e("Teste", "Pressed $input")
            eraseLastInput()
        } else if (input =="-/+") {
            changeResultSign()
        } else {
            lastInput = input
            displayOutput =  changeToOutputOrFormula(input, false) // change the keyboard input to be shown in calculator display
            formulaInput = changeToOutputOrFormula(input, true) // change the keyboard input to a formula input
            isMaxCharacter = checkIsMaxCharacters(displayText, maxCharacters) // check if maxCharacter is fulfilled
            if (!isMaxCharacter) {
                displayText = buttonToString(displayText, displayOutput) // update display string and checks max character
                displayFormula = buttonToFormula(displayFormula, formulaInput) // update display string and checks max character
            }
            refreshDisplay(displayText, isMaxCharacter)
            Log.i("teste", "O botão com texto $input foi clicado")
        }
    }

    fun resetDisplay() {
        if (isResult) {
            if (!mathError) {
                val i = lastResult.split('.')[0]
                val f = lastResult.split('.')[1]
                if (Math.floor(f.toDouble()) == 0.0) {
                    lastResult = i.toInt().toString()
                } else {
                    lastResult = tvDisplayResult.text.toString().toBigDecimal().toPlainString()
                }
            } else {
                lastResult = ""
            }
            displayFormula = lastResult
            displayText = lastResult
            tvDisplayCalc.text = lastResult
            tvDisplayResult.text = "0"
            isResult = false
            mathError = false
        }
    }

    fun calculateButtonPressed() {
        // val a = displayText // for debug purpose
        // var b = a.count() // for debug purpose
        if (displayText.count() > 0) {
            isResult = true
            val result = showResult(displayFormula)
            if (result == "MATH.ERROR"){
                mathError = true
            }
            tvDisplayResult.text = result
        }
    }
    fun showResult(displayFormula: String): String {
        //Log.e( "Actual","formula is $displayFormula")
        return calculateResult(displayFormula)
    }

    fun calculateResult(displayFormula: String):String{
        var substitute = displayFormula
        var isOperation = true
        substitute = insertMultiplySign(substitute)
        substitute = changePiEuler(substitute)
        val iterateTimes = 99
        for (n in 0..iterateTimes) {
            if (n == 99) {
                isOperation = false
                lastResult = "MATH.ERROR"
            }
            if (isOperation) {
                try {
                    substitute = resolveComplexOperations(substitute)
                    substitute = solveParenthesis(substitute)
                    substitute = solvePowMultiDiv(substitute)
                    substitute = solveSumSubstraction(substitute)

                    if (substitute.matches("-?\\d*\\.*\\d+?".toRegex())) {
                        isOperation = false
                    }
                } catch (e: Exception) {
                    isOperation = false
                }
            } else {
                try {
                    println(substitute.toDouble())
                    lastResult = substitute.toDouble().toString()
                    return lastResult
                } catch (e: Exception) {
                    return "MATH.ERROR"
                }
            }
        }
        return lastResult
    }

    fun insertMultiplySign(displayFormula: String): String {
        // Add the multiply sign where there's no math operator
        var substitute = displayFormula
        val arrayOfPattern: Array<String> = arrayOf(
                "(-?\\d*\\.*\\d+?\\()", // "1.0("
                "(\\))(\\d*\\.*\\d+?)", // ")1.0"
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
                    continue
                } else {
                    substitute = substitute.replace("$a$b", "$a*$b")
                    println("Conseguimos o seguinte resultado " + match.value)
                    println("Nova string é: $substitute")
                }
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
                when (i) {
                    0 -> substitute = substitute.replace(pattern, Math.E.toString())
                    1 -> substitute = substitute.replace(pattern, Math.PI.toString())
                }
                matches.next()
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
                    0 -> substitute = substitute.replace(pattern, kotlin.math.sin(number).toBigDecimal().toPlainString())
                    1 -> substitute = substitute.replace(pattern, kotlin.math.cos(number).toBigDecimal().toPlainString())
                    2 -> substitute = substitute.replace(pattern, kotlin.math.tan(number).toBigDecimal().toPlainString())
                    3 -> substitute = substitute.replace(pattern, kotlin.math.ln(number).toBigDecimal().toPlainString())
                    4 -> substitute = substitute.replace(pattern, kotlin.math.log10(number).toBigDecimal().toPlainString())
                    5 -> substitute = substitute.replace(pattern, (1/kotlin.math.cos(number)).toBigDecimal().toPlainString()) //secant = 1/cos(x)
                    6 -> substitute = substitute.replace(pattern, (1/kotlin.math.sin(number)).toBigDecimal().toPlainString()) // cossecant = 1/sin(x)
                    7 -> substitute = substitute.replace(pattern, (1/kotlin.math.tan(number)).toBigDecimal().toPlainString()) // cotangent = 1/tan(x)
                    8 -> substitute = substitute.replace(pattern, kotlin.math.sqrt(number).toBigDecimal().toPlainString())
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
                op_substitute = solvePowMultiDiv(op_substitute)
                op_substitute = solveSumSubstraction(op_substitute)
                substitute = substitute.replace(pattern, "($op_substitute)")
            }
        }
        return substitute
    }

    fun solvePowMultiDiv(args: String): String {
        val arrayOfPattern: Array<String> = arrayOf(
                "[A-z\\d\\)]\\-(\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)", // z - x^y
                "(-?\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)", // x^y
                "(-?\\d*\\.*\\d+?)\\/(-?\\d+\\.*\\d*)", // x/y
                "(-?\\d*\\.*\\d+?)\\*(-?\\d+\\.*\\d*)" // x*y
        )
        return solveOperations(arrayOfPattern, args)
    }

    fun solveSumSubstraction(args: String): String {
        val arrayOfPattern: Array<String> = arrayOf(
                "(-?\\d*\\.*\\d+?)\\+(-?\\d+\\.*\\d*)", // x+y
                "(-?\\d*\\.*\\d+?)\\-(-?\\d+\\.*\\d*)" // x-y
        )
        return solveOperations(arrayOfPattern, args)
    }

    fun solveOperations(arrayOfPattern: Array<String>, args: String ): String {
        var substitute = args
        for (i in arrayOfPattern) {
            val pattern = Regex(i)
            val matches = pattern.findAll(substitute).iterator()
            var a: Double
            var b: Double
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
                    "[A-z\\d\\)]\\-(\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(Regex("(\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)"), a.pow(b).toBigDecimal().toPlainString())
                    "(-?\\d*\\.*\\d+?)\\^(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(pattern, a.pow(b).toBigDecimal().toPlainString())
                    "(-?\\d*\\.*\\d+?)\\/(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(pattern, a.div(b).toBigDecimal().toPlainString())
                    "(-?\\d*\\.*\\d+?)\\*(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(pattern, a.times(b).toBigDecimal().toPlainString())
                    "(-?\\d*\\.*\\d+?)\\+(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(pattern, a.plus(b).toBigDecimal().toPlainString())
                    "(-?\\d*\\.*\\d+?)\\-(-?\\d+\\.*\\d*)" -> substitute = substitute.replace(pattern, a.minus(b).toBigDecimal().toPlainString())
                }
                println("Nova string é: $substitute")
            }
        }
        return substitute
    }

    fun updateHistory() {
        // var i = calculationHist.size // for debug purpose
        if (calculationHist.size > 9) {
            calculationHist = calculationHist.dropLast(1).toMutableList()
        }
        calculationHist.add(0, "$displayText = $lastResult")
        var history = ""
        for (i in calculationHist.indices){

            history += (i+1).toString() + ": " + calculationHist[i] + "\n"
        }
        tvHistory.text = history
    }

    fun eraseDisplay() {
        isResult = false
        tvDisplayResult.text = "0"
        tvDisplayCalc.text = ""
        displayText = ""
        displayFormula = ""
    }

    fun eraseLastInput() {
        if (tvDisplayCalc.text.count() > 0) {
            val lastDisplayCharacter = changeToOutputOrFormula(lastInput, false)
            val lastFormulaCharacter = changeToOutputOrFormula(lastInput, true)
            val lastCharacter = tvDisplayCalc.text[tvDisplayCalc.text.lastIndex]
            Log.e("Teste", "Last character is $lastCharacter")
            tvDisplayCalc.text = tvDisplayCalc.text.dropLast(lastDisplayCharacter.length)
            displayText = displayText.dropLast(lastDisplayCharacter.length)
            displayFormula = displayFormula.dropLast(lastFormulaCharacter.length)
            Log.e("Teste", "Formula = $displayFormula e Display = " + tvDisplayCalc.text)
        }
    }

    fun changeResultSign() {
        calculateButtonPressed()
        try {
            var result = lastResult.toDouble() * (-1)
            if (result == -0.0){ result = 0.0 }
            tvDisplayResult.text = result.toString()
            lastResult = result.toString()
        } catch (e: Exception) {
            mathError = true
        }
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
            //else if (input == "-/+"){ return "changeSign(" }
            return " "
            } else {
            if (input.isDigitsOnly() || input in arrayOf("+", "-", "%", "(", ")", ".", "÷", "×", "e", "π") ){ return input }
            else if (input in arrayOf("sin", "cos", "tan", "ln", "log", "sec", "csc", "ctn")){ return "$input(" }
            else if (input == "x!"){ return "fact(" }
            else if (input == "√"){ return "sqrt(" }
            else if (input == "x^y"){ return "^" }
            else if (input == "x^2"){ return "^2" }
            else if (input == "Inv"){ return "Inv(" }
            else if (input == "|x|"){ return "mod(" }
            return " "
        }
    }

    fun buttonToString(actual:String, new:String): String {
        Log.e("Teste", actual+new+ " DISPLAY")
        return actual + new
    }

    fun buttonToFormula(actual:String, new:String): String {
        val newString: String = actual + new
        Log.e("Teste", actual+new+ " FORMULA")
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
}
