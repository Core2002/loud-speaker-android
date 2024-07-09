package com.example.myapplication

import java.util.concurrent.TimeUnit.MILLISECONDS

object FormatTime {
    fun formatTime(millis: Long): String {
        val seconds = MILLISECONDS.toSeconds(millis)
        val minutes = MILLISECONDS.toMinutes(millis)
        val hours = MILLISECONDS.toHours(millis)
        return "$hours 小时 $minutes 分钟 $seconds 秒"
    }
}