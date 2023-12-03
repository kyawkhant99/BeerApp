package com.kkh.data.datasource.local

import androidx.paging.PagingSource
import com.kkh.data.datasource.local.db.entity.BeerEntity

interface BeerLocalDataSource {
    fun getBeerPagingSource():PagingSource<Int,BeerEntity>
}