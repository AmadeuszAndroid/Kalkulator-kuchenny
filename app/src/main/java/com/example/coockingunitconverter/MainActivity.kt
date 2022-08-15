package com.example.coockingunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coockingunitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convert.setOnClickListener { convertMeasures() }
    }

    private fun convertMeasures() {
        val stringInTextFiled = binding.valueToConvert.text.toString()
        val valueToConvert = stringInTextFiled.toDouble()
        val reverseConvert = binding.reverseCalculator.isChecked

        val selectedTablewareId = binding.tableware.checkedRadioButtonId

        val result: Double
        val multiplier = when (selectedTablewareId) {
            R.id.glasses -> 250
            R.id.spoons -> 15
            else -> 5
        }
        result = if (reverseConvert) {
            valueToConvert * multiplier
        } else {
            valueToConvert / multiplier
        }
        binding.result.text = result.toString()
    }
}