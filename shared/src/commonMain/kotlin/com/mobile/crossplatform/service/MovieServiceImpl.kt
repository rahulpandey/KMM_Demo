package com.mobile.crossplatform.service

import com.mobile.crossplatform.domain.Movie
import com.mobile.crossplatform.util.APIResponse
import com.mobile.crossplatform.util.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.readBytes

class MovieServiceImpl(private val client: HttpClient) : MovieService {
    override suspend fun discoverMovies(): APIResponse<Movie> {

        return try {
            val movie = client.get(HttpRoutes.DISCOVER_MOVIE).body<Movie>()
            APIResponse.Success(data = movie);
        } catch (ex: Exception) {
            ex.printStackTrace()
            APIResponse.Error(null, "Something went wrong")
        }
    }

    override suspend fun downloadImage(image: String): ByteArray? {
        return try {
            return client.get("${HttpRoutes.BASE_URL_IMAGE}$image").readBytes()
        } catch (e: Exception) {
            null
        }

    }
}