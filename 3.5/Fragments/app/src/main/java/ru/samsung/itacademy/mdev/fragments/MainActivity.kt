package ru.samsung.itacademy.mdev.fragments

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.samsung.itacademy.mdev.fragments.R.id
import ru.samsung.itacademy.mdev.fragments.R.layout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        var btn = findViewById<Button>(id.caption)
        var color1= findViewById<LinearLayout>(R.id.red);
        var color2= findViewById<LinearLayout>(R.id.blue);
        color1.setBackgroundColor(Color.RED)
        color2.setBackgroundColor(Color.BLUE);
        var flag = true;

        btn.setOnClickListener() {
            if(flag) {
                color1.setBackgroundColor(Color.BLUE);
                color2.setBackgroundColor(Color.RED);
                flag = false;
            }else{
                color1.setBackgroundColor(Color.RED)
                color2.setBackgroundColor(Color.BLUE);
                flag = true;
            }
            }
        }
    }


