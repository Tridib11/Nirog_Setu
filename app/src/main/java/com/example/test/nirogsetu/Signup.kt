package com.example.test.nirogsetu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        val etname=findViewById<EditText>(R.id.etname)
        val etemail=findViewById<EditText>(R.id.etemail)
        val etpassword=findViewById<EditText>(R.id.etpass)
        val signupbtn=findViewById<Button>(R.id.signupbtn)

        signupbtn.setOnClickListener {
            val name=etname.text.toString()
            val email=etemail.text.toString()
            val password=etpassword.text.toString()
            val user=Usersdata(name,email,password)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(name).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etemail.text?.clear()
                etpassword.text?.clear()
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed to Register",Toast.LENGTH_SHORT).show()
            }



        }



    }
}