package com.punith.mediumarticle

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform