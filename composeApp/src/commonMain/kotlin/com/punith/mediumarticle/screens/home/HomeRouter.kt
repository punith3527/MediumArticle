package com.punith.mediumarticle.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.punith.mediumarticle.LocalNavController
import com.punith.mediumarticle.screens.login.LoginParams
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeRouter(
  navEvents: Flow<HomeNavEvent>,
) {
  val rootNavController = LocalNavController.current
  LaunchedEffect(Unit) {
    navEvents.collect {
      when (it) {
        is HomeNavEvent.NavigateToLogin -> {
          rootNavController.navigate(LoginParams(fromScreen = "home")) {
            popUpTo(0) { inclusive = true }
          }
        }
        is HomeNavEvent.NavigateToProfile -> {
          rootNavController.navigate(it.params)
        }
      }
    }
  }
}
