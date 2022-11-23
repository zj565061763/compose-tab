package com.sd.lib.compose.temp

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FTabIndicator(
    tabPositions: List<TabPosition>,
    selectedTabIndex: Int,
    width: Dp? = null,
    height: Dp = 2.dp,
    color: Color = LocalContentColor.current,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .appTabIndicatorOffset(
                currentPosition = tabPositions[selectedTabIndex],
                width = width,
            )
            .height(height)
            .background(color)

    )
}

private fun Modifier.appTabIndicatorOffset(
    currentPosition: TabPosition,
    width: Dp? = null,
): Modifier = composed {

    val targetWidth = width ?: currentPosition.width
    val widthValue = animateDpAsState(
        targetValue = targetWidth,
        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing)
    ).value

    val targetOffset = if (width == null) {
        currentPosition.left
    } else {
        currentPosition.left + (currentPosition.width - width) / 2
    }
    val offsetValue = animateDpAsState(
        targetValue = targetOffset,
        animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing)
    ).value

    wrapContentSize(Alignment.BottomStart)
        .offset(x = offsetValue)
        .width(widthValue)
}