package com.mobile.crossplatform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mobile.crossplatform.componet.MovieList
import com.mobile.crossplatform.domain.Result
import com.mobile.crossplatform.service.MovieService
import com.mobile.crossplatform.util.APIResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App(movieService: MovieService) {
    val viewScope = rememberCoroutineScope()
    var movies by remember { mutableStateOf(emptyList<Result>()) }
    var error by remember { mutableStateOf("") }
    viewScope.launch {
        when (val movie = movieService.discoverMovies()) {
            is APIResponse.Success -> {
                delay(5 * 1000)
                movies = movie.data?.results ?: emptyList()
            }

            is APIResponse.Error -> {
                error = movie.message.toString()
            }
        }
    }
    val platform = getPlatform()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Top App Bar ${platform.name}")
            },
            contentColor = Color.White,
            elevation = 10.dp
        )
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(visible = movies.isEmpty() && error.isBlank()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) { CircularProgressIndicator(color = Color.Blue, strokeWidth = 2.dp) }
            }
            AnimatedVisibility(visible = movies.isNotEmpty()) {
                MovieList(movies)
            }
            AnimatedVisibility(visible = error.isBlank().not()) {
                Text(text = error)
            }

        }
    }

}