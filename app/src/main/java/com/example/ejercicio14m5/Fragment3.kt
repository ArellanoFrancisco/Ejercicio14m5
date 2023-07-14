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
import com.example.ejercicio14m5.databinding.Fragment3Binding
import com.example.ejercicio14m5.VmodelCompartida





class Fragment3 : Fragment() {
    private lateinit var binding: Fragment3Binding
    private lateinit var vmodelCompartida: VmodelCompartida
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)
        navController = findNavController()
        vmodelCompartida = ViewModelProvider(requireActivity())[VmodelCompartida::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button3.setOnClickListener { Retirar()}
    }

    private fun Retirar(){
        val montoString = binding.Monto3.text.toString()
        val saldo = vmodelCompartida.saldo.value ?:0
        if (montoString.isNotEmpty()) {
            val giro = montoString.toIntOrNull() ?: 0
            if (giro<saldo) {
                vmodelCompartida.retirar(giro)
                navController.navigate(R.id.action_fragment3_to_fragment4)
                Toast.makeText(requireContext(), R.string.mensaje1, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), R.string.mensaje2, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), R.string.mensaje2, Toast.LENGTH_SHORT).show()}
    }
}


