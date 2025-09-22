package com.gallardoromero.carlos.gallardo.a1step.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HelpSession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val habitId: Int,
    val reasonKey: String, //"time", "tired" , "dontknow", "other"
    val note: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    var resolved: Boolean = false,
    var resolvedAt: Long? = null
)
