package com.ahmed.invadetask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahmed.invadetask.common.StringListConverter
import com.ahmed.invadetask.model.University

@Database(entities = [University::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverter::class)
abstract class UniversityDatabase : RoomDatabase() {

    abstract fun universityDao(): UniversityDao
}
