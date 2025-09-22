package com.gallardoromero.carlos.gallardo.a1step.models

import androidx.room.PrimaryKey

data class HelpMessage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sessionId: Int,
    val fromUser: Boolean,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)
