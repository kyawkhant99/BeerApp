package com.kkh.beerapp.ui.home

import androidx.lifecycle.ViewModel
import com.kkh.domain.usecase.GetBeerPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class BeerHomeViewModel @Inject constructor(getBeerPaging: GetBeerPaging):ViewModel() {


    val pagings = getBeerPaging.invoke()

}