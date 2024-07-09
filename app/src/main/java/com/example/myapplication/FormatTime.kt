package com.example.myapplication

object FormatTime {
    fun formatTime(millis: Long): String {
        val seconds = (millis / 1000) % 60
        val minutes = (millis / (1000 * 60)) % 60
        val hours = (millis / (1000 * 60 * 60)) % 60
        return String.format("%2d小时%2d分钟%2d秒", hours, minutes, seconds)
    }
}