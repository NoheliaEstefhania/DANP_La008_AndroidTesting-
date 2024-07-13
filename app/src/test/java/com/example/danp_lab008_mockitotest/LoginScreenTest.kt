package com.example.danp_lab008_mockitotest

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.danp_lab008_mockitotest.test.AuthViewModel
import com.example.danp_lab008_mockitotest.ui.LoginScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mock
    private lateinit var mockAuthViewModel: AuthViewModel

    @Test
    fun loginScreen_authenticated() {
        `when`(mockAuthViewModel.isAuthenticated.observeAsState().value).thenReturn(true)

        composeTestRule.setContent {
            LoginScreen(authViewModel = mockAuthViewModel)
        }

        composeTestRule.onNodeWithText("Authenticated").assertExists()
    }

    @Test
    fun loginScreen_authenticationFailed() {
        `when`(mockAuthViewModel.isAuthenticated.observeAsState().value).thenReturn(false)

        composeTestRule.setContent {
            LoginScreen(authViewModel = mockAuthViewModel)
        }
        composeTestRule.onNodeWithText("Authentication failed").assertExists()
    }
}
