package com.example.exam


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)

        findViewById<Button>(R.id.add).setOnClickListener {
            val n1 = num1.text.toString().toDouble()
            val n2 = num2.text.toString().toDouble()
            result.text = calculate(n1, n2, "add").toString()
        }

        findViewById<Button>(R.id.subtract).setOnClickListener {
            val n1 = num1.text.toString().toDouble()
            val n2 = num2.text.toString().toDouble()
            result.text = calculate(n1, n2, "subtract").toString()
        }

        findViewById<Button>(R.id.multiply).setOnClickListener {
            val n1 = num1.text.toString().toDouble()
            val n2 = num2.text.toString().toDouble()
            result.text = calculate(n1, n2, "multiply").toString()
        }

        findViewById<Button>(R.id.divide).setOnClickListener {
            val n1 = num1.text.toString().toDouble()
            val n2 = num2.text.toString().toDouble()
            result.text = calculate(n1, n2, "divide").toString()
        }
    }

    private fun calculate(num1: Double, num2: Double, operation: String): Double {
        return when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> num1 / num2
            else -> 0.0
        }
    }
}
