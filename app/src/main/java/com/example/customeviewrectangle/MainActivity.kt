package com.example.customeviewrectangle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var customRectangleView: CustomRectangleView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customRectangleView = findViewById(R.id.customView)
        btn = findViewById(R.id.btn_swap_color)

        btn.setOnClickListener{

            customRectangleView.swapColor()
        }
    }
}