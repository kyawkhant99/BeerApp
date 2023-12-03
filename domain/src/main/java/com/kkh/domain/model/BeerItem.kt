package com.kkh.domain.model

import com.kkh.data.datasource.local.db.entity.BeerEntity

data class BeerItem(
    val id: Int,
    val description: String,
    val imageUrl: String,
    val name: String,
    val tagline: String
)

fun BeerEntity.toDomain() = BeerItem(id, description, imageUrl, name, tagline)
