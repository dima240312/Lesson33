package com.example.lesson32_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lesson32_fragment.databinding.FragmentOneBinding

class Fragment_One : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment_One.observe(activity as LifecycleOwner) {
            binding.tvMessageOne.text = it
        }
        binding.buttonSendToFragmentTwo.setOnClickListener {
            dataModel.messageForFragment_Two.value = "Hello from fragment 1"
        }
        binding.buttonSendToActivityMain.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment_One()
    }
}