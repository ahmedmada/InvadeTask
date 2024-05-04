package com.ahmed.invadetask

import com.ahmed.invadetask.data.local.UniversityDao
import com.ahmed.invadetask.data.repositry.UniversityLocalRepository
import com.ahmed.invadetask.model.University
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class LocalRepositoryTest {

    private val mockDao: UniversityDao = mock()

    @Test
    fun `test fetching universities from local repository`() {
        runBlocking {
            val mockedUniversities = listOf(
                University(1, "AUC", "Egypt", "http://auc.com"),
                University(2, "GUC", "Egypt", "http://guc.com")
            )
            whenever(mockDao.getAll()).thenReturn(mockedUniversities)

            val repository = UniversityLocalRepository(mockDao)

            val universities = repository.getAllUniversities()

            assertNotNull(universities)
        }
    }
}
