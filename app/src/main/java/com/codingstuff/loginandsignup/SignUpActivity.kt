package com.codingstuff.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

import com.google.android.material.textfield.TextInputEditText

import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {


     lateinit var firebaseAuth: FirebaseAuth
    lateinit var button: AppCompatButton
    lateinit var emailEt: TextInputEditText
    lateinit var passET: TextInputEditText
    lateinit var confirmPassEt : TextInputEditText
    lateinit var textViewRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button = findViewById(R.id.buttonRegister)
        emailEt = findViewById(R.id.emailEt)
        passET = findViewById(R.id.passET)
        confirmPassEt = findViewById(R.id.confirmPassEt)
        textViewRegister = findViewById(R.id.textView)



        firebaseAuth = FirebaseAuth.getInstance()

        textViewRegister.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val email = emailEt.text.toString()
            val pass = passET.text.toString()
            val confirmPass = confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}