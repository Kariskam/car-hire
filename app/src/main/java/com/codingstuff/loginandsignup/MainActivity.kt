package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codingstuff.loginandsignup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubaruforester.setOnClickListener {
            replaceFragment(subaru())

        }
        binding.buttonHighlander.setOnClickListener {
            replaceFragment(highlander())

        }
        binding.buttonHilux.setOnClickListener {
            replaceFragment(hilux())

        }
        binding.buttonVEight.setOnClickListener {
            replaceFragment(veight())

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home,fragment)
        fragmentTransaction.commit()

    }
}