package com.example.ejercicio14m5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VmodelCompartida : ViewModel() {

    private val _saldo = MutableLiveData<Int>()
    val saldo: LiveData<Int> get() = _saldo

    init {
        _saldo.value = 10000
    }

    fun depositar(deposito: Int) {
        _saldo.value = _saldo.value?.plus(deposito)
    }

    fun retirar(retiro: Int) {
        _saldo.value = _saldo.value?.minus(retiro)
    }
}