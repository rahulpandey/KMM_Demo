package com.mobile.crossplatform.service

import com.mobile.crossplatform.domain.Movie
import com.mobile.crossplatform.util.APIResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


interface MovieService {
    suspend fun discoverMovies(): APIResponse<Movie>
    suspend fun downloadImage(image: String): ByteArray?

    companion object {
        fun create(): MovieService {
            val httpClient = HttpClient {
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL

                }
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
            return MovieServiceImpl(httpClient)
        }
    }
}