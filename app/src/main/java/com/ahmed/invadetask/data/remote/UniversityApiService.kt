package com.ahmed.invadetask.data.remote

import com.ahmed.invadetask.model.University
import retrofit2.http.GET

interface UniversityApiService {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(): List<University>
}
