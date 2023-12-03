package com.kkh.data.datasource.local

import androidx.paging.PagingSource
import com.kkh.data.datasource.local.db.dao.BeerDao
import com.kkh.data.datasource.local.db.entity.BeerEntity
import javax.inject.Inject

class BeerLocalDataSourceImpl @Inject constructor(private val dao:BeerDao): BeerLocalDataSource {
    override fun getBeerPagingSource(): PagingSource<Int, BeerEntity> {
        return dao.pagingSource()
    }
}