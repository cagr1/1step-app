package com.gallardoromero.carlos.gallardo.a1step.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Progress(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val habitId: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val completed: Boolean = false
)