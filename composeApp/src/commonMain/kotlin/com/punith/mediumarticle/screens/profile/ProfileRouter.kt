package com.punith.mediumarticle.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.punith.mediumarticle.LocalNavController
import com.punith.mediumarticle.screens.login.LoginParams
import kotlinx.coroutines.flow.Flow

@Composable
fun ProfileRouter(
  navEvents: Flow<ProfileNavEvent>,
) {
  val rootNavController = LocalNavController.current
  LaunchedEffect(Unit) {
    navEvents.collect { event ->
      when (event) {
        is ProfileNavEvent.NavigateBack -> rootNavController.popBackStack()

        is ProfileNavEvent.NavigateToLogin -> {
          rootNavController.navigate(LoginParams(fromScreen = "profile")) {
            popUpTo(0) { inclusive = true }
          }
        }
      }
    }
  }
}
