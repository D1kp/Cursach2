package ru.samsung.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private var backToast:Toast ?= null
    private var backPressedTime:Long ?= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override  fun onBackPressed(){
        if(backPressedTime!! + 2000>System.currentTimeMillis())
        {
            backToast?.cancel()
            super.onBackPressed()
            finish()
            return
        }
        else{
            backToast = Toast.makeText(baseContext,"Нажми еще раз, что бы выйти", Toast.LENGTH_SHORT)
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}
