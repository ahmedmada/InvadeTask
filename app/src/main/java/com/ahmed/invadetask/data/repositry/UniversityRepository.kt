package com.ahmed.invadetask.data.repositry

import com.ahmed.invadetask.data.remote.UniversityApiService
import com.ahmed.invadetask.model.University

class UniversityRepository(private val apiService: UniversityApiService) {
    suspend fun getUniversities(): List<University> {
        return apiService.getUniversities()
    }
}
