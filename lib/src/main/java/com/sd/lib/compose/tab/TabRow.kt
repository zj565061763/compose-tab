package com.sd.lib.compose.tab

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        FTabIndicator(
            tabPositions = tabPositions,
            selectedTabIndex = selectedTabIndex,
            width = 30.dp,
        )
    },
    divider: @Composable @UiComposable () -> Unit =
        @Composable {
            Divider(thickness = Dp.Hairline)
        },
    tabs: @Composable @UiComposable () -> Unit,
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = indicator,
        divider = divider,
        tabs = tabs,
    )
}

@Composable
fun FScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    edgePadding: Dp = 0.dp,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        FTabIndicator(
            tabPositions = tabPositions,
            selectedTabIndex = selectedTabIndex,
            width = 20.dp,
        )
    },
    divider: @Composable @UiComposable () -> Unit =
        @Composable {
            Divider(thickness = Dp.Hairline)
        },
    tabs: @Composable @UiComposable () -> Unit,
) {
    ScrollableTabRowMinimumTabWidthHook
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        edgePadding = edgePadding,
        indicator = indicator,
        divider = divider,
        tabs = tabs,
    )
}

private val ScrollableTabRowMinimumTabWidthHook by lazy {
    try {
        val clazz = Class.forName("androidx.compose.material3.TabRowKt")
        val field = clazz.getDeclaredField("ScrollableTabRowMinimumTabWidth").apply {
            isAccessible = true
        }
        field.set(null, 0f)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}