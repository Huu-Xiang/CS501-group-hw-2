package com.example.cs501_group_activity_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DashboardScreen()
                }
            }
        }
    }
}


@Composable
fun DashboardScreen() {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Interactive Dashboard", fontSize = 24.sp, modifier = Modifier.padding(bottom = 32.dp))
        Text(text = "Current Count: $count", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        CounterControl(
            countValue = count,
            onIncrement = { count++ },
            onReset = { count = 0 }
        )
    }
}

@Composable
fun CounterControl(countValue: Int, onIncrement: () -> Unit, onReset: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = onIncrement) { Text("Add 1") }
        OutlinedButton(onClick = onReset) { Text("Reset") }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    MaterialTheme {
        DashboardScreen()
    }
}