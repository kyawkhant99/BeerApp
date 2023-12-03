package com.kkh.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kkh.data.datasource.local.db.dao.BeerDao
import com.kkh.data.datasource.local.db.entity.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1
)
abstract class BeerDatabase: RoomDatabase() {

    abstract val dao: BeerDao
}