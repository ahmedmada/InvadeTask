package com.ahmed.invadetask

import com.ahmed.invadetask.data.remote.UniversityApiService
import com.ahmed.invadetask.data.repositry.UniversityRepository
import com.ahmed.invadetask.model.University
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemoteRepositoryTest {

    private val mockApiService: UniversityApiService = mock()

    @Test
    fun `test fetching universities from remote repository`() {
        runBlocking {
            val mockedUniversities = listOf(
                University(1, "AUC", "Egypt", "http://auc.com"),
                University(2, "GUC", "Egypt", "http://guc.com")
            )

            whenever(mockApiService.getUniversities()).thenReturn(mockedUniversities)

            val repository = UniversityRepository(mockApiService)

            val universities = repository.getUniversities()

            assertNotNull(universities)
        }
    }
}
