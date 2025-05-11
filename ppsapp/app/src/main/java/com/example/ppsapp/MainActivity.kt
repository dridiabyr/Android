package com.example.ppsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ComputableLiveData
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvComputerChoice: TextView

    private val choices = listOf("Pierre","Papier","Ciseaux")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        tvComputerChoice = findViewById(R.id.tvComputerChoice)

        findViewById<Button>(R.id.BtnPierre).setOnClickListener {
            playGame("Pierre")
        }
        findViewById<Button>(R.id.BtnPapier).setOnClickListener {
            playGame("Papier")
        }

        findViewById<Button>(R.id.BtnCiseaux).setOnClickListener {
            playGame("Ciseaux")
        }

    }

    private fun playGame(userChoice: String){
        val ComputerChoice = choices[Random.nextInt(3)]
        tvComputerChoice.text = "L'ordinateur a choisi :$ComputerChoice "

        val result =  when {
            userChoice == ComputerChoice -> "Égalité !"
            userChoice == "Pierre" && ComputerChoice == "Ciseaux" -> "Vous gagnez !"
            userChoice == "Papier" && ComputerChoice == "Pierre" -> "Vous gagnez !"
            userChoice == "Ciseaux" && ComputerChoice == "Papier" -> "Vous gagnez !"
            else -> "Vous perdez !"
        }
        tvResult.text = result
    }
}