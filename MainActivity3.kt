package com.example.sexy

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {

    private lateinit var results: TextView
    private lateinit var averageView : TextView
    var data: String = ""
    var block: String = ""
    var average:Int = 0
    var totalMorning: Int = 0
    var totalAfternoon: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        averageView = findViewById(R.id.average)
        results = findViewById(R.id.results)
        results.setMovementMethod(ScrollingMovementMethod())




        for (note in notes.withIndex()) {

            var index = note.index

//This where i use parrallel array
            val row = "Date : ${dates[index]}\nMorning :${morningMinutes[index]}\nAfternoon :${afternoonMinutes[index]}\nNotes :${note.value}"

            data += "$row\n\n\n\n"


        }


        for(time in morningMinutes.withIndex()){

            totalMorning = totalMorning + time.value

            totalAfternoon = totalAfternoon + afternoonMinutes[time.index]


        }

//Average
        average = (totalMorning + totalAfternoon)/morningMinutes.size
// average view
        averageView.text = "Average : ${average}"

        results.text = data
    }
}