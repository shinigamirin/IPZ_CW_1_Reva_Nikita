package ua.edu.lntu.cw_1_2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

@Composable
fun SignInScreen(viewModel: SignInViewModel, navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Sign In") },
                backgroundColor = Color.Blue
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it },
                    placeholder = { Text("Email") },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
                TextField(
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    placeholder = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
                Text(
                    text = viewModel.result.value,
                    style = MaterialTheme.typography.body1,
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(
                    onClick = {
                        val email = viewModel.email.value.text.trim()
                        val password = viewModel.password.value.text.trim()

                        if (email.isEmpty()) {
                            viewModel.result.value = "Помилка: Поле Email порожнє"
                            return@Button
                        }

                        if (password.isEmpty()) {
                            viewModel.result.value = "Помилка: Поле Password порожнє"
                            return@Button
                        }
                        viewModel.result.value = "Успішна авторизація"
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Sign In")
                }
            }
        }
    )
}