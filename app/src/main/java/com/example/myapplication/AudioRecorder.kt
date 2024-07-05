package com.example.myapplication

import android.annotation.SuppressLint
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioRecord
import android.media.AudioTrack
import android.media.MediaRecorder
import kotlin.concurrent.thread

object AudioRecorder {

    private var isRecording = false

    private var sampleRateInHz: Int = 44100
    private var bufferSize = AudioRecord.getMinBufferSize(
        sampleRateInHz,
        AudioFormat.CHANNEL_IN_STEREO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    private lateinit var audioRecord: AudioRecord
    private lateinit var audioTrack: AudioTrack

    private fun doRecord() {
        isRecording = true
        val buffer = ByteArray(bufferSize)
        while (isRecording) {
            val byteSize = audioRecord.read(buffer, 0, bufferSize)
            if (byteSize >= AudioRecord.SUCCESS)
                audioTrack.write(buffer, 0, byteSize)
        }
    }

    @SuppressLint("MissingPermission")
    fun doStart() {
        if (isRecording) return

        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            sampleRateInHz,
            AudioFormat.CHANNEL_IN_STEREO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )
        audioTrack = AudioTrack(
            AudioManager.STREAM_MUSIC,
            sampleRateInHz,
            AudioFormat.CHANNEL_OUT_STEREO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize,
            AudioTrack.MODE_STREAM
        )

        audioRecord.startRecording()
        audioTrack.play()

        thread {
            doRecord()
        }
    }

    fun doStop() {
        if (!isRecording) return

        isRecording = false
        audioRecord.stop()
        audioTrack.stop()
        audioRecord.release()
        audioTrack.release()
    }

}