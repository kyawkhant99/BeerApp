package com.kkh.data.datasource.local.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.kkh.data.datasource.local.db.entity.BeerEntity

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(beers: List<BeerEntity>)

    @Query("SELECT * FROM Beer")
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM Beer")
    suspend fun clearAll()
}