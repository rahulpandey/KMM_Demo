package com.mobile.crossplatform.util

object HttpRoutes {
    private const val BASE_URL = "https://api.themoviedb.org/3"
     const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
    const val DISCOVER_MOVIE =
        "$BASE_URL/discover/movie?api_key=a1c56489f3e4f6afe9797102bf33ace1&include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc"
}