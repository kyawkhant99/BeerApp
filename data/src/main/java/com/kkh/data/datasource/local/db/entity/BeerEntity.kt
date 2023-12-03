package com.kkh.data.datasource.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Beer"
)
data class BeerEntity(
    @PrimaryKey
    val id: Int,
    val description: String,
    val imageUrl: String,
    val name: String,
    val tagline: String,
)
