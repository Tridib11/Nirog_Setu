package com.example.test.nirogsetu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.hide()
        val sign_up=findViewById<Button>(R.id.signupbtn1)
        sign_up.setOnClickListener {
            val intent=Intent(this,Signup::class.java)
            startActivity(intent)
        }


    }
}