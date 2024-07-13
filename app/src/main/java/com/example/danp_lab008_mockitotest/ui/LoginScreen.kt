package com.example.danp_lab008_mockitotest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.danp_lab008_mockitotest.test.AuthViewModel

@Composable
fun LoginScreen(authViewModel: AuthViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isAuthenticated by authViewModel.isAuthenticated.observeAsState()

    Column {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { authViewModel.authenticate(username, password) }) {
            Text("Login")
        }
        isAuthenticated?.let {
            if (it) {
                Text("Authenticated")
            } else {
                Text("Authentication failed")
            }
        }
    }
}