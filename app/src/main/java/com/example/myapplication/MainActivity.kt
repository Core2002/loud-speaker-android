package com.example.myapplication

import android.annotation.SuppressLint
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.nio.ByteBuffer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DiceRollerApp()
            }
        }
    }

}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

var coroutineScope = CoroutineScope(Dispatchers.Default)

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            coroutineScope.launch {
                doRecord()
            }
            coroutineScope.launch {
                doPlay()
            }
        }) {
            Text(text = "Start")
        }

        Button(onClick = {
            doStop()
            coroutineScope.cancel()
//            doRelease()
        }) {
            Text(text = "Stop")
        }
    }
}

var isRecording = false

var sampleRate = 16000
var bufferSize = AudioRecord.getMinBufferSize(
    sampleRate,
    AudioFormat.CHANNEL_IN_MONO,
    AudioFormat.ENCODING_PCM_16BIT
)
var buffer = ByteBuffer.allocate(bufferSize)

//var net = ByteBuffer.allocate(bufferSize)
@SuppressLint("MissingPermission")
var audioRecord = AudioRecord(
    MediaRecorder.AudioSource.MIC,
    sampleRate,
    AudioFormat.CHANNEL_IN_MONO,
    AudioFormat.ENCODING_PCM_16BIT,
    bufferSize
)

var audioTrack = AudioTrack(
    AudioManager.STREAM_MUSIC,
    sampleRate,
    AudioFormat.CHANNEL_OUT_MONO,
    AudioFormat.ENCODING_PCM_16BIT,
    bufferSize,
    AudioTrack.MODE_STREAM
)

fun doRecord() {
    audioRecord.startRecording()
    isRecording = true
    while (isRecording) {
//        audioRecord.sta
        var read = audioRecord.read(buffer, 0, bufferSize)
        if (read > 0) {
            buffer.putInt(read)
        }
    }
}

fun doPlay() {
    audioTrack.play()
    while (isRecording) {
        audioTrack.write(buffer, 0, bufferSize)
    }
}

fun doStop() {
    isRecording = false
    audioRecord.stop()
    audioTrack.stop()
}

fun doRelease() {
    audioRecord.release()
    audioTrack.release()
}
