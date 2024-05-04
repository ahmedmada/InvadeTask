package com.ahmed.invadetask.common

import com.ahmed.invadetask.model.University

sealed class Result {
    data class Success(val universities: List<University>) : Result()
    data class Error(val message: String) : Result()
}

