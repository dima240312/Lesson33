package com.example.lesson32_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lesson32_fragment.databinding.FragmentTwoBinding

class Fragment_Two : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment_Two.observe(activity as LifecycleOwner) {
            binding.tvMessageTwo.text = it
        }
        binding.buttonSendToFragmentOne.setOnClickListener {
            dataModel.messageForFragment_One.value = "Hello from fragment 2"
        }
        binding.buttonSendToActivityMain.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment_Two()
    }
}