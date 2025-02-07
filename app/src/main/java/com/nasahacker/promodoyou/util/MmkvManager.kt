package com.nasahacker.promodoyou.util

import com.tencent.mmkv.MMKV

object MmkvManager {

    private val mmkv by lazy {
        MMKV.defaultMMKV()
    }


    fun incrementWorkTime(): Long {
        mmkv.encode(Constant.PREF_WORK_TIME, getWorkTime() + 1)
        return getWorkTime()
    }

    fun decrementWorkTime(): Long {
        mmkv.encode(Constant.PREF_WORK_TIME, getWorkTime() - 1)
        return getWorkTime()
    }


    fun incrementBreakTime(): Long {
        mmkv.encode(Constant.PREF_BREAK_TIME, getBreakTime() + 1)
        return getBreakTime()
    }

    fun decrementBreakTime(): Long {
        mmkv.encode(Constant.PREF_BREAK_TIME, getBreakTime() - 1)
        return getBreakTime()
    }


    fun getWorkTime(): Long = mmkv.decodeLong(Constant.PREF_WORK_TIME, 25)

    fun getBreakTime(): Long = mmkv.decodeLong(Constant.PREF_BREAK_TIME, 5)


}