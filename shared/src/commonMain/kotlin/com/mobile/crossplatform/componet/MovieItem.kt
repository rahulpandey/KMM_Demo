package com.mobile.crossplatform.componet

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.crossplatform.domain.Result
import com.mobile.crossplatform.util.HttpRoutes
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun MovieItem(result: Result) {
    Card(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ), modifier = Modifier.padding(horizontal = 6.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            key(result.id) {
                val painterResource =
                    asyncPainterResource(data = "${HttpRoutes.BASE_URL_IMAGE}/${result.backdropPath}")
                KamelImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    resource = painterResource,
                    contentScale = ContentScale.Crop,
                    contentDescription = "movieImages",
                    animationSpec = tween()
                )
            }
            Text(
                text = result.title,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 20.sp)
            )
            Text(
                text = result.overview,
                Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
        }

    }
}