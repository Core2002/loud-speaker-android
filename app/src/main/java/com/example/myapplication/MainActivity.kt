package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                RecordMainPage()
            }
        }
    }

}

@Preview
@Composable
fun RecordMainPage() {
    var statusText by remember {
        mutableStateOf("欢迎使用")
    }
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = statusText,
            fontSize = 28.sp
        )
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(80.dp),
            onClick = {
                statusText = "捕获已启用"
                AudioRecorder.doStart()
            }) {
            Text(
                text = "开始",
                fontSize = 32.sp
            )
        }

        Button(
            modifier = Modifier
                .width(200.dp)
                .height(80.dp),
            onClick = {
                statusText = "捕获已结束"
                AudioRecorder.doStop()
            }) {
            Text(
                text = "停止",
                fontSize = 32.sp
            )
        }
    }
}
