package com.gallardoromero.carlos.gallardo.a1step.models

import android.content.ClipDescription
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val description: String? = null,
    val frequency: String = "daily",
    val createAt: Long = System.currentTimeMillis()
)