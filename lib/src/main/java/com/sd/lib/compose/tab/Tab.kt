package com.sd.lib.compose.tab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FTab(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    enabled: Boolean = true,
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = 0.3f),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        interactionSource = interactionSource,
        content = content,
    )
}