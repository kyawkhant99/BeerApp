package com.kkh.data.api

import com.kkh.data.response.beer.BeerDataItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): List<BeerDataItemResponse>

    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}