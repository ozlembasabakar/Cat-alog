package com.example

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.feature.post.R
import com.example.ui.theme.PinterestCloneTheme
import com.example.ui.theme.PostCardRowPadding
import com.example.ui.theme.Shapes

private const val THUMBNAIL_DIMENSION = 50
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PostCard(
    modifier: Modifier,
    image: String?,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(Shapes.small)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        GlideImage(
            model = image,
            contentDescription = stringResource(R.string.image_description),
            //previewPlaceholder = R.drawable.images_1,
            modifier = Modifier
                .fillMaxWidth()
                .clip(Shapes.small),
            contentScale = ContentScale.Crop
        ) {
            it.thumbnail(
                it.clone().override(THUMBNAIL_DIMENSION)
            ).diskCacheStrategy(DiskCacheStrategy.ALL)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = PostCardRowPadding,
                    end = PostCardRowPadding,
                    top = PostCardRowPadding
                ),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.more_icon),
                contentDescription = stringResource(R.string.more_options),
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PostCardPreview() {
    PinterestCloneTheme {
        PostCard(modifier = Modifier, image = R.drawable.images_1.toString())
    }
}
