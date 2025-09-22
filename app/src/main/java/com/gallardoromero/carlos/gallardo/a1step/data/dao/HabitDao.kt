package com.gallardoromero.carlos.gallardo.a1step.data.dao

import androidx.room.*
import com.gallardoromero.carlos.gallardo.a1step.models.Habit

@Dao
interface HabitDao {
    @Insert
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query("SELECT * FROM Habit ORDER BY createdAt DESC")
    suspend fun getAllHabits(): List<Habit>
}
