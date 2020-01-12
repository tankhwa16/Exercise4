package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal = Calendar.getInstance()
        val today = Calendar.getInstance()


        val datePicker = object : DatePickerDialog.OnDateSetListener{

            override fun onDateSet(view : DatePicker, year : Int, month: Int, day: Int){


                cal.set(year, month, day)

                val dateFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(dateFormat, Locale.UK)


                val age =  today.get(Calendar.YEAR) - cal.get(Calendar.YEAR)

                textAge.setText("Age: " + age.toString())

                var savings : Int


                if(age in 16..20)
                    savings = 5000
                else if(age in 21..25)
                    savings = 14000
                else if(age in 26..30)
                    savings = 29000
                else if(age in 31..35)
                    savings = 50000
                else if(age in 36..40)
                    savings = 78000
                else if(age in 41..45)
                    savings = 116000
                else if(age in 46..50)
                    savings = 165000
                else if (age in 51..55)
                    savings = 228000
                else
                    savings = 0

                textSaving.text = "Min. Savings: " + savings.toString()
            }
        }

        dateBt.setOnClickListener{

            val datePickerDialog = DatePickerDialog(this, datePicker, cal.get(Calendar.YEAR), cal.get(
                Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()


        }

        resetBt.setOnClickListener { reset() }
    }

    fun reset(){
        textAge.text = "Age: "
        textSaving.text = "Min. Savings: "
    }
}