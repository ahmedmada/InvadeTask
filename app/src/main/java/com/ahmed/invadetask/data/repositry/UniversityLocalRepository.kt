package com.ahmed.invadetask.data.repositry

import com.ahmed.invadetask.data.local.UniversityDao
import com.ahmed.invadetask.model.University

class UniversityLocalRepository(private val universityDao: UniversityDao) {
    fun getAllUniversities(): List<University> {
        return universityDao.getAll()
    }

    suspend fun insertUniversities(universities: List<University>) {
        universityDao.insertAll(universities)
    }
}
