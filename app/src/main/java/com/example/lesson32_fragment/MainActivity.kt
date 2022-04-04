package com.example.lesson32_fragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lesson32_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        openFragment(Fragment_One(), R.id.fragment1_placeholder)
        openFragment(Fragment_Two(), R.id.fragment2_placeholder)

        dataModel.messageForFragment_One.observe(this) {
            binding.mainMessageBox.text = it
        }
         dataModel.messageForFragment_Two.observe(this) {
            binding.mainMessageBox.text = it
        }
         dataModel.messageForActivity.observe(this) {
            binding.mainMessageBox.text = it
        }

    }

    private fun openFragment(whatFragment: Fragment, whatLayout: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(whatLayout, whatFragment)
            .commit()
    }
}