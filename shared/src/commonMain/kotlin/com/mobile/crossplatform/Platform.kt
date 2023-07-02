package com.mobile.crossplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform