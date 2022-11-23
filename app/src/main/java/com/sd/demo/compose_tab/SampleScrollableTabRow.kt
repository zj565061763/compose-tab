package com.sd.demo.compose_tab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sd.demo.compose_tab.ui.theme.AppTheme
import com.sd.lib.compose.temp.FScrollableTabRow

class SampleScrollableTabRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Content()
                }
            }
        }
    }

    init {
        try {
            Class
                .forName("androidx.compose.material3.TabRowKt")
                .getDeclaredField("ScrollableTabRowMinimumTabWidth").apply {
                    isAccessible = true
                }.set(this, 0f)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Composable
private fun Content() {
    val listTab = remember {
        mutableListOf<String>().also { list ->
            repeat(50) {
                list.add(it.toString())
            }
        }
    }
    var selectedTab by remember { mutableStateOf(listTab[0]) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FScrollableTabRow(
            selectedTabIndex = listTab.indexOf(selectedTab),
            modifier = Modifier.fillMaxWidth()
        ) {
            listTab.forEach { item ->
                Tab(
                    selected = item == selectedTab,
                    onClick = {
                        selectedTab = item
                    },
                    modifier = Modifier
                        .height(45.dp)
                        .widthIn(45.dp)
                ) {
                    Text(text = item)
                }
            }
        }
    }
}
