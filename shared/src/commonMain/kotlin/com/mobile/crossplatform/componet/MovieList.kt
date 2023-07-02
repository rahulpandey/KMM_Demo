package com.mobile.crossplatform.componet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.crossplatform.domain.Result

@Composable
fun MovieList(results: List<Result>) {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        item { Spacer(Modifier.height(0.dp)) }
        items(results) { result ->
            MovieItem(result)
        }
        item { Spacer(Modifier.height(0.dp)) }
    }
}