package com.example.practice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var nameView: EditText? = null
    private var heightView: EditText? = null
    private var weightView: EditText? = null
    private var ageView: EditText? = null
    private var button: Button? = null
    private var answerText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameView = findViewById(R.id.editTextTextName)
        heightView = findViewById(R.id.editTextHeight)
        weightView = findViewById(R.id.editTextWeight)
        ageView = findViewById(R.id.editTextAge)
        button = findViewById(R.id.button)
        answerText = findViewById(R.id.textView)

        answerText?.setVisibility(TextView.INVISIBLE)

        button?.setOnClickListener()
        {
            if (heightView?.text.toString().isEmpty() || weightView?.text.toString().isEmpty() || ageView?.text.toString().isEmpty())
            {
                answerText?.setTextColor(Color.parseColor("#FF0000"))
                answerText?.setText("Данные введены некорректно.")
                answerText?.setVisibility(TextView.VISIBLE)
            }
            else
            {
                val height = heightView?.text.toString().toInt()
                val weight = weightView?.text.toString().toInt()
                val age = ageView?.text.toString().toInt()

                val allow = ((0 < height && height < 250) && (0 < weight && weight < 250) && (0 < age && age < 150))

                val answer = (height + weight) * age

                if (!allow)
                {
                    answerText?.setTextColor(Color.parseColor("#FF0000"))
                    answerText?.setText("Данные введены некорректно.")
                    answerText?.setVisibility(TextView.VISIBLE)
                }
                else
                {
                    val str = "Ответ: $answer"
                    answerText?.setText(str)
                    answerText?.setTextColor(Color.parseColor("#008001"))
                    answerText?.setVisibility(TextView.VISIBLE)
                }
            }

        }
    }


}