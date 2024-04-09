package ua.edu.lntu.cw_1_2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val result = mutableStateOf("")
}