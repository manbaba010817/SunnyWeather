package com.tianqiyubao.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tianqiyubao.android.logic.Repository
import com.tianqiyubao.sunnyweather.logic.dao.PlaceDao

import com.tianqiyubao.sunnyweather.logic.model.Place

class PlaceViewModel:ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place)=Repository.savePlace(place)

    fun getSavedPlace()= PlaceDao.getSavedPlace()

    fun isPlaceSaved()= PlaceDao.isPlacesSaved()



}