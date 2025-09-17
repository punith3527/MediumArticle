package com.punith.mediumarticle

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.punith.mediumarticle.di.ApplicationComponent
import com.punith.mediumarticle.di.create
import com.punith.mediumarticle.global.CustomSnackbarHost
import com.punith.mediumarticle.global.GlobalPopupLayer
import org.jetbrains.compose.ui.tooling.preview.Preview

// CompositionLocal for accessing the ApplicationComponent throughout the app
val LocalApplicationComponent = compositionLocalOf<ApplicationComponent> {
  error("ApplicationComponent not provided")
}

@Composable
@Preview
fun App() {
  val applicationComponent = remember { ApplicationComponent::class.create() }

  CompositionLocalProvider(LocalApplicationComponent provides applicationComponent) {
    MaterialTheme {
      Scaffold(
        snackbarHost = { CustomSnackbarHost() }
      ) { _ ->
        GlobalPopupLayer { 
          Navigator() 
        }
      }
    }
  }
}