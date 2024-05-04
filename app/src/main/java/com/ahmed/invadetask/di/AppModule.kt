package com.ahmed.invadetask.di

import android.app.Application
import androidx.room.Room
import com.ahmed.invadetask.data.local.UniversityDao
import com.ahmed.invadetask.data.local.UniversityDatabase
import com.ahmed.invadetask.data.remote.UniversityApiService
import com.ahmed.invadetask.data.repositry.UniversityLocalRepository
import com.ahmed.invadetask.data.repositry.UniversityRepository
import com.ahmed.invadetask.data.usecase.UniversityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://universities.hipolabs.com/"

    @Singleton
    @Provides
    fun provideUniversityApiService(): UniversityApiService {
        return createUniversityApiService()
    }

    @Singleton
    @Provides
    fun provideUniversityDatabase(application: Application): UniversityDatabase {
        return Room.databaseBuilder(
            application,
            UniversityDatabase::class.java,
            "university_database"
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideUniversityDao(database: UniversityDatabase): UniversityDao {
        return database.universityDao()
    }

    @Singleton
    @Provides
    fun provideUniversityRepository(apiService: UniversityApiService): UniversityRepository {
        return UniversityRepository(apiService)
    }

    @Singleton
    @Provides
    fun provideUniversityLocalRepository(universityDao: UniversityDao): UniversityLocalRepository {
        return UniversityLocalRepository(universityDao)
    }

    @Singleton
    @Provides
    fun provideUniversityUseCase(
        universityRepository: UniversityRepository,
        universityLocalRepository: UniversityLocalRepository
    ): UniversityUseCase {
        return UniversityUseCase(universityRepository, universityLocalRepository)
    }

    private fun createUniversityApiService(): UniversityApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(UniversityApiService::class.java)
    }
}
