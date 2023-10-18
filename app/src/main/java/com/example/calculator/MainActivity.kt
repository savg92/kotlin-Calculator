package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputField: EditText //lateint la propiedad, no es necesario que tenga un dato: Inicialización posterior
    private var operand : Double = 0.0
    private var operator : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputField = findViewById(R.id.inputNum)
    }

    fun clearCalculation(view: View){
        inputField.text.clear()
        operand = 0.0
        operator =  null
    }

    fun clickOperand(view: View){
        val buttonOperand = view as Button
        val currentText = inputField.text.toString()
        val newText = currentText + buttonOperand.text.toString()
        inputField.setText(newText)
    }

    fun clickOperator(view: View){
        val buttonOperator = view as Button
        operator = buttonOperator.text.toString()
        operand = inputField.text.toString().toDouble()
        inputField.text.clear()
    }

    fun clickDot(view: View){
        if(!inputField.text.contains(".")){
            inputField.text.append(".")
        }
    }

    fun clickPlusMinus(view: View){
        val text = inputField.text.toString()
        val newText = if(text.startsWith("-")){
            text.substring(1)
        }else{
            "-$text"
        }
        inputField.setText(newText)
    }

    fun clickPercent(view: View){
        val value = inputField.text.toString().toDouble()/100
        inputField.setText(value.toString())
    }

    fun equalTo(view: View) {
        val secondOperandText = inputField.text.toString()
        if (secondOperandText.isNotEmpty()) {
            val secondOperand = secondOperandText.toDouble()
            val result = when(operator){
                "+" -> operand + secondOperand
                "-" -> operand - secondOperand
                "*" -> operand * secondOperand
                "÷" -> operand / secondOperand
                else -> secondOperand
            }
            inputField.setText(result.toString())
        }
    }
}