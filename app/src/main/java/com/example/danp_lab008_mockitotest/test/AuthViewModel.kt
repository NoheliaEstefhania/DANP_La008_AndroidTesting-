package com.example.danp_lab008_mockitotest.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> = _isAuthenticated

    fun authenticate(username: String, password: String) {
        viewModelScope.launch {
            val isAuthenticated = authRepository.authenticate(username, password)
            _isAuthenticated.value = isAuthenticated
        }
    }
}
