package com.example.counterapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private  var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val counterText: TextView=findViewById(R.id.counterText)
        val Increment: Button =findViewById(R.id.btnIncrement)
        val Decrement: Button=findViewById(R.id.btnDecrement)
        val Reset: Button=findViewById(R.id.btnReset)
        val mainLayout :LinearLayout = findViewById(R.id.main)


        Increment.setOnClickListener {
            counter ++
            counterText.text = counter.toString()
            blinkRandomColor(mainLayout)
        }

        Decrement.setOnClickListener {
            if (counter > 0){
                counter--
                counterText.text=counter.toString()
                blinkRandomColor(mainLayout)
            }
        }

        Reset.setOnClickListener {
            counter = 0
            counterText.text= counter.toString()
            Toast.makeText(this, "counter reset ! ", Toast.LENGTH_SHORT).show()
            blinkRandomColor(mainLayout)
        }


    }
    private fun blinkRandomColor(layout: LinearLayout) {
        val randomColor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
        layout.setBackgroundColor(randomColor)

        Handler(Looper.getMainLooper()).postDelayed({
            layout.setBackgroundColor(Color.parseColor("#F2DADA"))
            },500)
}
}