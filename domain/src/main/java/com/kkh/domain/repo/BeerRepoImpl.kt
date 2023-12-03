package com.kkh.domain.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.kkh.data.datasource.local.BeerLocalDataSource
import com.kkh.data.datasource.remote.BeerRemoteMediator
import com.kkh.domain.model.BeerItem
import com.kkh.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BeerRepoImpl @Inject constructor(
    private val localDataSource: BeerLocalDataSource,
    private val remoteDataSource: BeerRemoteMediator
) : BeerRepo {
    @OptIn(ExperimentalPagingApi::class)
    override fun getBeerPaging(): Flow<PagingData<BeerItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = remoteDataSource,
            pagingSourceFactory = {
                localDataSource.getBeerPagingSource()
            }
        ).flow.map { paging -> paging.map { it.toDomain() } }
    }
}