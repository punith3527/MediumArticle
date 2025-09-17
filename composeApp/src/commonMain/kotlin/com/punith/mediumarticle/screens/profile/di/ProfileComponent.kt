package com.punith.mediumarticle.screens.profile.di

import com.punith.mediumarticle.di.ApplicationComponent
import com.punith.mediumarticle.screens.profile.ProfileParams
import com.punith.mediumarticle.screens.profile.ProfileViewModel
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import me.tatarka.inject.annotations.Scope

@Scope
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
annotation class ProfileScope

@ProfileScope
@Component
abstract class ProfileComponent(
    @get:Provides val params: ProfileParams,
    @Component val applicationComponent: ApplicationComponent,
) {
    
    // ViewModels for this screen
    abstract val profileViewModel: ProfileViewModel
    
    companion object
}
