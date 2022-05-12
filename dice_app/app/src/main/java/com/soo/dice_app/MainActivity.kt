package com.soo.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.soo.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.diceStartBtn.setOnClickListener{
            val num1 = Random.nextInt(1, 6).toString()
            val num2 = Random.nextInt(1, 6).toString()

            Log.d("MainActivity", num1)
            Log.d("MainActivity", num2)

            binding.dice1.setImageResource(resources.getIdentifier("dice_"+num1, "drawable", getPackageName()))
            binding.dice2.setImageResource(resources.getIdentifier("dice_"+num2, "drawable", getPackageName()))
        }
    }
}