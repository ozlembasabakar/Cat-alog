package com.example.pinterestclone.bottombar

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pinterestclone.R
import com.example.pinterestclone.ui.theme.BottomBarHorizontalPadding
import com.example.pinterestclone.ui.theme.BottomBarVerticalPadding
import com.example.ui.theme.PinterestCloneTheme

@Composable
fun BottomBar(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = BottomBarVerticalPadding, horizontal = BottomBarHorizontalPadding),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(modifier = modifier, icon = R.drawable.home_icon)
        BottomBarItem(modifier = modifier, icon = R.drawable.search_icon)
        BottomBarItem(modifier = modifier, icon = R.drawable.profile_icon)
    }
}

@Preview(name = "LightMode")
@Preview(name = "DarkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomBarPreview() {
    PinterestCloneTheme {
        BottomBar(Modifier)
    }
}