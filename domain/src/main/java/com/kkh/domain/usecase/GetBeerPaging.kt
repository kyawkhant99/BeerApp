package com.kkh.domain.usecase

import com.kkh.domain.repo.BeerRepo
import javax.inject.Inject

class GetBeerPaging @Inject constructor(private val repo: BeerRepo) {
    fun invoke() = repo.getBeerPaging()
}