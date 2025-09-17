package com.punith.mediumarticle.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.punith.mediumarticle.LocalNavController
import kotlinx.coroutines.flow.Flow

@Composable
fun LoginRouter(
  navEvents: Flow<LoginNavEvent>,
) {
  val navController = LocalNavController.current
  LaunchedEffect(Unit) {
    navEvents.collect {
      when (it) {
        is LoginNavEvent.NavigateToHome -> {
          navController.navigate(
            it.homeParams
          ) {
            popUpTo(LoginParams()) { inclusive = true }
          }
        }
      }
    }
  }
}
