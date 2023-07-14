package com.example.ejercicio14m5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ejercicio14m5.databinding.Fragment4Binding

class Fragment4 : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: Fragment4Binding
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton
    private lateinit var button1: Button

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        binding = Fragment4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        radioButton1 = binding.radioButton1
        radioButton2 = binding.radioButton2
        radioButton3 = binding.radioButton3
        radioButton4 = binding.radioButton4
        button1 = binding.button1


        button1.setOnClickListener {
            if (radioButton1.isChecked) {
                navController.navigate(R.id.action_fragment4_to_fragment1)
            } else if (radioButton2.isChecked) {
                navController.navigate(R.id.action_fragment4_to_fragment2)
            } else if (radioButton3.isChecked) {
                navController.navigate(R.id.action_fragment4_to_fragment3)
            } else if (radioButton4.isChecked) {
                requireActivity().finish()
            }
        }
    }

}
