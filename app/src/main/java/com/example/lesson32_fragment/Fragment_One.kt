package com.example.lesson32_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson32_fragment.databinding.FragmentOneBinding

class Fragment_One : Fragment() {
lateinit var binding:FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__one, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentOneBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)


        binding.showExtra.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment4_placeholder,Fragment_Four())
                .commit()
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fragment4_placeholder,Fragment_Four())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment_One()

    }
}