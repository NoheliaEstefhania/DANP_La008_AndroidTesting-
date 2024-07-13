package com.example.danp_lab008_mockitotest.test

interface AuthRepository {
    suspend fun authenticate(username: String, password: String): Boolean
}

class AuthRepositoryImpl : AuthRepository {
    override suspend fun authenticate(username: String, password: String): Boolean {
        return username == "admin" && password == "password"
    }
}

