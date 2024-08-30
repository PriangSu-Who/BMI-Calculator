package com.example.bmicalculator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcBmiButton.setOnClickListener {

            val age = binding.ageInput.text.toString().toInt()
            val height = binding.heightInput.text.toString().toDouble()/100
            val weight = binding.weightInput.text.toString().toInt()

            val totalBmi = weight / (height*height)
            binding.bmiOutput.text = String.format("Your BMI is: %.2f", totalBmi)

           binding.bmiTypeOutput.text = when(totalBmi) {
                in 0.0..18.5 -> "Underweight"
                in 18.5..24.9 -> "Normal weight"
                in 25.0..29.9 -> "Overweight"
                else -> "Obesity"
            }

        }
    }
}