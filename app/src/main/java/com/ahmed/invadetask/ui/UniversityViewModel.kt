package com.ahmed.invadetask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.invadetask.common.Result
import com.ahmed.invadetask.data.usecase.UniversityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    private val universityUseCase: UniversityUseCase
) : ViewModel() {


    private val _result = MutableLiveData<Result>(Result.Success(emptyList()))
    val result = _result

    init {
        fetchUniversities()
    }

    private fun fetchUniversities() {
        viewModelScope.launch {
            universityUseCase.getUniversities().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _result.value = Result.Success(result.universities)
                    }

                    is Result.Error -> {
                        _result.value = Result.Error(result.message)
                    }
                }
            }
        }
    }
}
