package com.example.myapplication

import java.util.concurrent.TimeUnit.MILLISECONDS

object FormatTime {
    fun formatTime(millis: Long): String {
        val seconds = MILLISECONDS.toSeconds(millis) % 24
        val minutes = MILLISECONDS.toMinutes(millis) % 60
        val hours = MILLISECONDS.toHours(millis) % 60
        return "$hours 小时 $minutes 分钟 $seconds 秒"
    }
}