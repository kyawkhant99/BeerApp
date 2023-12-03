package com.kkh.domain.di

import com.kkh.domain.repo.BeerRepo
import com.kkh.domain.repo.BeerRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindRepo(repoImpl: BeerRepoImpl):BeerRepo
}