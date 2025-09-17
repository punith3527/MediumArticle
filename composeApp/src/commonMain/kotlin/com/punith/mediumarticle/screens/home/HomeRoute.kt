package com.punith.mediumarticle.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.punith.mediumarticle.arch.BaseRoute
import com.punith.mediumarticle.screens.home.compose.HomeView
import com.punith.mediumarticle.screens.home.di.HomeComponent
import com.punith.mediumarticle.screens.home.di.create
import kotlinx.serialization.Serializable

/**
 * Navigation parameters for Home screen
 */
@Serializable
data class HomeParams(
  val userEmail: String,
  val userName: String,
  val loginType: String,
)

@Composable
fun HomeRoute(backStackEntry: NavBackStackEntry) {
  BaseRoute<HomeViewModel, HomeState, HomeUIEvent, HomeNavEvent, HomeUIEffect, HomeParams>(
    backStackEntry = backStackEntry,
    componentProvider = { params, applicationComponent ->
      HomeComponent::class.create(params, applicationComponent).homeViewModel
    },
    router = { navEvents ->
      HomeRouter(navEvents = navEvents)
    }
  ) { state, onEvent, uiEffects ->
    HomeView(
      state = state,
      onEvent = onEvent,
      uiEffects = uiEffects
    )
  }
}

