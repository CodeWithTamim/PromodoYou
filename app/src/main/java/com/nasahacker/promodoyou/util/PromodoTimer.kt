package com.nasahacker.promodoyou.util

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import java.text.DecimalFormat

class PromodoTimer(private val initialTimeInMinutes: Long) {

    private var countdownTimer: CountDownTimer? = null
    private var timeLeftInMs: Long = initialTimeInMinutes * 60000
    val currentTime = MutableLiveData<String>()
    var isRunning = false

    init {
        updateTimeDisplay(timeLeftInMs)
    }

    private fun updateTimeDisplay(ms: Long) {
        val f = DecimalFormat("00")
        val hour = (ms / 3600000) % 24
        val min = (ms / 60000) % 60
        val sec = (ms / 1000) % 60
        currentTime.value = "${f.format(hour)}:${f.format(min)}:${f.format(sec)}"
    }

    fun startTimer() {
        if (isRunning) return
        countdownTimer = object : CountDownTimer(timeLeftInMs, 1000) {
            override fun onTick(ms: Long) {
                timeLeftInMs = ms
                updateTimeDisplay(ms)
            }

            override fun onFinish() {
                currentTime.value = "00:00:00"
                isRunning = false
            }
        }.also {
            it.start()
            isRunning = true
        }
    }

    fun pauseTimer() {
        if (isRunning) {
            countdownTimer?.cancel()
            isRunning = false
        }
    }

    fun resetTimer() {
        countdownTimer?.cancel()
        timeLeftInMs = initialTimeInMinutes * 60000
        updateTimeDisplay(timeLeftInMs)
        isRunning = false
    }
}
