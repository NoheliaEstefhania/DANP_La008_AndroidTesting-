package com.example.danp_lab008_mockitotest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.danp_lab008_mockitotest.test.AuthRepositoryImpl
import com.example.danp_lab008_mockitotest.test.AuthViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel = AuthViewModel(AuthRepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(authViewModel = authViewModel)
        }
    }
}