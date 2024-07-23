package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculator = findViewById<Button>(R.id.buttonCalculator)
        val buttonInterestCalculator = findViewById<Button>(R.id.buttonInterestCalculator)

        buttonCalculator.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Data for Calculator App")
            startActivity(intent)
        }

        buttonInterestCalculator.setOnClickListener {
            val intent = Intent(this, InterestCalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Data for Interest Calculator App")
            startActivity(intent)
        }
    }
}