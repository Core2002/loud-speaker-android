package com.example.myapplication

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.myapplication.FormatTime.formatTime
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    var statusText by remember { mutableStateOf("欢迎使用") }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (isGranted) {
                statusText = "捕获已启用"
                AudioRecorder.doStart()
            } else {
                statusText = "麦克风权限被拒绝"
            }
        }
    )
    var isRecording by remember { mutableStateOf(false) }
    var elapsedTime by remember { mutableLongStateOf(0L) }
    val coroutineScope = rememberCoroutineScope()
    val formattedTime = remember(elapsedTime) { formatTime(elapsedTime) }
    val modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = statusText, // 显示状态文本
            fontSize = 50.sp
        )
        Text(
            text = "本次使用时间：\n$formattedTime",
            textAlign = TextAlign.Center,// 显示计时文本
            style = TextStyle(lineHeight = 50.sp),
            fontSize = 30.sp
        )
        Button(
            modifier = Modifier
                .width(200.dp)
                .height(80.dp),
            onClick = {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.RECORD_AUDIO
                    ) != android.content.pm.PackageManager.PERMISSION_GRANTED
                ) {
                    launcher.launch(Manifest.permission.RECORD_AUDIO)
                } else {
                    isRecording = !isRecording
                    statusText = if (isRecording) "捕获已启用" else "捕获已结束"

                    if (isRecording) {
                        AudioRecorder.doStart()
                        coroutineScope.launch {
                            while (isRecording) {
                                delay(1000L)
                                elapsedTime += 1000L
                            }
                        }
                    } else {
                        AudioRecorder.doStop()
                    }
                }
            }) {
            Text(
                text = if (isRecording) "停止" else "开始",
                fontSize = 32.sp
            )
        }

    }
}


