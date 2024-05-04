package com.ahmed.invadetask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmed.invadetask.model.University

@Dao
interface UniversityDao {
    @Query("SELECT * FROM universities")
    fun getAll(): List<University>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(universities: List<University>)
}
