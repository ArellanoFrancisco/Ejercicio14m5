package com.example.ejercicio14m5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.ejercicio14m5.databinding.Fragment2Binding
import com.example.ejercicio14m5.VmodelCompartida





class Fragment2 : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding: Fragment2Binding
    private lateinit var vmodelCompartida: VmodelCompartida

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)
        navController = findNavController()
        vmodelCompartida = ViewModelProvider(requireActivity())[VmodelCompartida::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener { Depositar()}
    }

    private fun Depositar() {
        val montoString = binding.Monto2.text.toString()
        if (montoString.isNotEmpty()) {
            val deposito = montoString.toIntOrNull() ?: 0
            if (deposito > 0) {
                vmodelCompartida.depositar(deposito)
                navController.navigate(R.id.action_fragment2_to_fragment4)
                Toast.makeText(requireContext(), R.string.mensaje1, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), R.string.mensaje2, Toast.LENGTH_SHORT).show()
                }
            } else {Toast.makeText(requireContext(), R.string.mensaje2, Toast.LENGTH_SHORT).show()}
        }
    }

