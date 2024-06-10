package com.example.sexy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast

import java.util.*

var notes = mutableListOf<String>()
var dates = mutableListOf<String>()
var morningMinutes = mutableListOf<Int>()
var afternoonMinutes = mutableListOf<Int>()
var isValid: Boolean = true

class MainActivity2 : AppCompatActivity() {

    private lateinit var submit: Button
    private lateinit var pickTime: Button
    private lateinit var clear: Button
    private lateinit var nextPage: Button

    private lateinit var timeView: TextView
    private lateinit var notesView: EditText
    private lateinit var morningView: EditText
    private lateinit var afternoonView: EditText
    private lateinit var error: TextView


    var selectedDate: String = ""

    fun check(number1: Int,number2: Int) {

        if (number1 > 120 || number2 > 120 ) {
            isValid = false
            error.text = "P;ease enter a valid number"

        } else {
            isValid = true
        }


    }

    //function to pick time
    fun showDatePickerDialog() {

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog =
            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->


                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                //Show seled day
                Toast.makeText(this, "Selected Date: $selectedDate", Toast.LENGTH_LONG).show()

                timeView.text = selectedDate


            }, year, month, day)

        datePickerDialog.show()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        submit = findViewById(R.id.submit)
        pickTime = findViewById(R.id.pickDate)
        timeView = findViewById(R.id.dateName)
        clear = findViewById(R.id.clear)
        nextPage = findViewById(R.id.showMore)


        notesView = findViewById(R.id.taskNameInput)
        morningView = findViewById(R.id.morningInput)
        afternoonView = findViewById(R.id.afternoonInput)
        error = findViewById(R.id.error)

        pickTime.setOnClickListener {
            showDatePickerDialog()


        }


        submit.setOnClickListener {


            var date = selectedDate
            var morning = morningView.text.toString().toInt()
            var afternoon = afternoonView.text.toString().toInt()
            var note = notesView.text.toString()


            //check

            check(afternoon,morning)
//checking of the number is a valid number
            if(isValid== true){

                notes.add(note)
                dates.add(date)
                morningMinutes.add(morning)
                afternoonMinutes.add(afternoon)

                println(notes)
                println(dates)
                println(morningMinutes)
                println(afternoonMinutes)

                timeView.text = "Please selecct Date"
                morningView.text.clear()
                afternoonView.text.clear()
                notesView.text.clear()
            }


        }


        clear.setOnClickListener {
            timeView.text = "Please selecct Date"
            morningView.text.clear()
            afternoonView.text.clear()
            notesView.text.clear()

        }

        nextPage.setOnClickListener {

            val intent = Intent(this, MainActivity3::class.java)

            startActivity(intent)

        }


    }
}