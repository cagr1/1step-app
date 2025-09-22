package com.gallardoromero.carlos.gallardo.a1step.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gallardoromero.carlos.gallardo.a1step.data.dao.HabitDao
import com.gallardoromero.carlos.gallardo.a1step.data.dao.ProgressDao
import com.gallardoromero.carlos.gallardo.a1step.models.Habit
import com.gallardoromero.carlos.gallardo.a1step.models.Progress

@Database(entities = [Habit::class, Progress::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun progressDao(): ProgressDao
}