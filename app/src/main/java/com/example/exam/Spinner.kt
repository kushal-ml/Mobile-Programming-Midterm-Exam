package com.example.exam

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView

class InterestCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner)

        val principalInput = findViewById<EditText>(R.id.principal)
        val rateInput = findViewById<EditText>(R.id.rate)
        val timeInput = findViewById<EditText>(R.id.time)
        val result = findViewById<TextView>(R.id.result)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.calculateButton)

        ArrayAdapter.createFromResource(
            this,
            R.array.interest_type_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        button.setOnClickListener {
            try {
                val principal = principalInput.text.toString().toDouble()
                val rate = rateInput.text.toString().toDouble()
                val time = timeInput.text.toString().toDouble()
                val interestType = spinner.selectedItem.toString()

                val interest = if (interestType == "Simple Interest") {
                    calculateSimpleInterest(principal, rate, time)
                } else {
                    calculateCompoundInterest(principal, rate, time)
                }

                result.text = "Interest: $interest"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateSimpleInterest(principal: Double, rate: Double, time: Double): Double {
        return (principal * rate * time) / 100
    }

    private fun calculateCompoundInterest(principal: Double, rate: Double, time: Double): Double {
        return principal * Math.pow((1 + rate / 100), time) - principal
    }
}
