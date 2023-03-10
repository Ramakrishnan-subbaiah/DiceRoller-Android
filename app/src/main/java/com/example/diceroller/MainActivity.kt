package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//setting onclick listener to the button
      //calling rollDice to roll the dice
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()

    }

    private fun rollDice() {
        //passing no of sides into Dice class with object instance
       val dice = Dice(6)
       val diceRoll = dice.roll()
        //changing images based on diceRoll value which is get from roll() function
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        diceImage.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int){
//roll() returns a no from 1 to no of sides
    fun roll(): Int{
        return (1..numSides).random()
    }
}