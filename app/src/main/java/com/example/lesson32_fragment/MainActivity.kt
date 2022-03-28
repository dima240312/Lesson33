package com.example.lesson32_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson32_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.showFragments.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment1_placeholder,Fragment_One())
                .commit()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment2_placeholder,Fragment_Two())
                .commit()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment3_placeholder,Fragment_Three())
                .commit()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment4_placeholder,Fragment_Four())
                .commit()
        }
    }
}