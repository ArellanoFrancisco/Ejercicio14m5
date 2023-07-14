package com.example.ejercicio14m5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ejercicio14m5.databinding.Fragment1Binding
import java.text.NumberFormat
import java.util.*



class Fragment1 : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: Fragment1Binding
    private lateinit var vmodelCompartida: VmodelCompartida

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        vmodelCompartida = ViewModelProvider(requireActivity())[VmodelCompartida::class.java]
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        binding.button4.setOnClickListener {
            navController.navigate(R.id.action_fragment1_to_fragment4)
        }
        vmodelCompartida.saldo.observe(viewLifecycleOwner) { saldo ->
            val currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
            currencyFormat.maximumFractionDigits = 0
            binding.Monto1.text = currencyFormat.format(saldo)
        }
    }
}

