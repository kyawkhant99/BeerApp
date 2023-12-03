package com.kkh.domain.repo

import androidx.paging.PagingData
import com.kkh.domain.model.BeerItem
import kotlinx.coroutines.flow.Flow

interface BeerRepo {
    fun getBeerPaging(): Flow<PagingData<BeerItem>>
}