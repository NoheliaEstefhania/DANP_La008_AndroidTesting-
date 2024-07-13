package com.example.danp_lab008_mockitotest

import com.example.danp_lab008_mockitotest.test.AuthRepository
import com.example.danp_lab008_mockitotest.test.AuthViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthViewModelTest {

    @Mock
    private lateinit var mockAuthRepository: AuthRepository

    private lateinit var authViewModel: AuthViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        authViewModel = AuthViewModel(mockAuthRepository)
    }

    @Test
    fun `authenticate should update isAuthenticated LiveData`() = runBlocking {
        //Arrange
        val username = "testUser"
        val password = "testPass"
        Mockito.`when`(mockAuthRepository.authenticate(username, password)).thenReturn(true)

        //Act
        authViewModel.authenticate(username, password)

        //Assert
        assertEquals(true, authViewModel.isAuthenticated.value)
    }
}
