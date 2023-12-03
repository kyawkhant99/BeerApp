package com.kkh.data.response.beer

import com.kkh.data.datasource.local.db.entity.BeerEntity

data class BeerDataItemResponse(
    val description: String?,
    val id: Int,
    val image_url: String?,
    val name: String?,
    val tagline: String?,
)

fun BeerDataItemResponse.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name.orEmpty(),
        tagline = tagline.orEmpty(),
        description = description.orEmpty(),
        imageUrl = image_url.orEmpty()
    )
}