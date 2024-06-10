package com.example.sexy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.widget.Button
import kotlinx.coroutines.delay
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    //Declarationd

    private lateinit var nextButton: Button
    private lateinit var exitButton: Button
    var isPressed: Boolean = false

    //Time delay
    private fun runTimer(intent: Intent) {


        CoroutineScope(Dispatchers.Main).launch {
            delay(5000)

            if (isPressed == false) {

                startActivity(intent)
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Intent to change page
        val intent = Intent(this, MainActivity2::class.java)
//function with delay


        nextButton = findViewById(R.id.next)

        exitButton = findViewById(R.id.exit)

        nextButton.setOnClickListener {


            startActivity(intent)

        }

        exitButton.setOnClickListener {

            isPressed = true

            finishAffinity()

        }

        runTimer(intent)


    }
}