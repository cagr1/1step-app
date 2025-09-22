package com.gallardoromero.carlos.gallardo.a1step.data.dao

import androidx.room.*
import com.gallardoromero.carlos.gallardo.a1step.models.Progress

@Dao
interface ProgressDao {
    @Insert
    suspend fun insertProgress(progress: Progress)

    @Query("SELECT * FROM Progress WHERE habitId = :habitId ORDER BY timestamp DESC")
    suspend fun getProgressForHabit(habitId: Int): List<Progress>
}