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
        val valueToConvert = stringInTextFiled.toDoubleOrNull()
        if (valueToConvert == null) {
            binding.result.text = ""
            return
        }
        val reverseConvert = binding.reverseCalculator.isChecked

        val multiplier = when (binding.tableware.checkedRadioButtonId) {
            R.id.glasses -> 250
            R.id.spoons -> 15
            else -> 5
        }

        binding.result.text = getString(R.string.result, if (reverseConvert) {
            (valueToConvert * multiplier).toInt().toString()
        } else {
            String.format("%.2f", valueToConvert / multiplier)
        })
    }
}