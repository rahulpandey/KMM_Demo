package com.mobile.crossplatform

import androidx.compose.ui.window.ComposeUIViewController
import com.mobile.crossplatform.service.MovieService

fun createService() = MovieService.create()
fun MainViewController(movieService: MovieService) = ComposeUIViewController { App(movieService) }
