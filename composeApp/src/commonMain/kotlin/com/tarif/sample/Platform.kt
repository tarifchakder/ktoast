package com.tarif.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform