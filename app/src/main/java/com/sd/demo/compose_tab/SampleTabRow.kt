package com.sd.demo.compose_tab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sd.demo.compose_tab.ui.theme.AppTheme
import com.sd.lib.compose.tab.FTab
import com.sd.lib.compose.tab.FTabRow

class SampleTabRow : ComponentActivity() {
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
}

@Composable
private fun Content() {
    val listTab = remember { listOf("手机", "平板电脑") }
    var selectedTab by remember { mutableStateOf(listTab[0]) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FTabRow(
            selectedTabIndex = listTab.indexOf(selectedTab),
            modifier = Modifier.fillMaxWidth()
        ) {
            listTab.forEach { item ->
                FTab(
                    selected = item == selectedTab,
                    onClick = { selectedTab = item },
                    modifier = Modifier.height(45.dp)
                ) {
                    Text(text = item)
                }
            }
        }
    }
}
