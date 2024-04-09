package ua.edu.lntu.cw_1_2

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.signInScreen(
    viewModel: SignInViewModel,
    onSignInSuccess: () -> Unit
) {
    composable("signIn") {
        SignInScreen(viewModel = viewModel)
    }
}