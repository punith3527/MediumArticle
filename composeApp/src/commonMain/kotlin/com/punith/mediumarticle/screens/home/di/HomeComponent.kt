package com.punith.mediumarticle.screens.home.di

import com.punith.mediumarticle.di.ApplicationComponent
import com.punith.mediumarticle.network.ApiClient
import com.punith.mediumarticle.screens.home.HomeParams
import com.punith.mediumarticle.screens.home.HomeViewModel
import com.punith.mediumarticle.screens.home.data.NetworkRepositoryService
import com.punith.mediumarticle.screens.home.data.RepositoryService
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import me.tatarka.inject.annotations.Scope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
annotation class HomeScope

@HomeScope
@Component
abstract class HomeComponent(
  @get:Provides val params: HomeParams,
  @Component val applicationComponent: ApplicationComponent,
) {
  abstract val homeViewModel: HomeViewModel

  @HomeScope
  @Provides
  fun provideRepositoryService(apiClient: ApiClient): RepositoryService {
    return NetworkRepositoryService(apiClient)
  }

  companion object
}
