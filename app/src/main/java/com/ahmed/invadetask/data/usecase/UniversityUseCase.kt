package com.ahmed.invadetask.data.usecase

import com.ahmed.invadetask.common.Result
import com.ahmed.invadetask.data.repositry.UniversityLocalRepository
import com.ahmed.invadetask.data.repositry.UniversityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UniversityUseCase @Inject constructor(
    private val universityRepository: UniversityRepository,
    private val universityLocalRepository: UniversityLocalRepository
) {

    fun getUniversities(): Flow<Result> = flow {
        val result = try {
            val data = universityRepository.getUniversities()
            universityLocalRepository.insertUniversities(data)
            Result.Success(data)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error occurred")
        }
        emit(result)
    }.catch { e ->
        emit(Result.Error(e.message ?: "Unknown error occurred"))
    }
}
