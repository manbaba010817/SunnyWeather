package com.tianqiyubao.sunnyweather.logic.network;



import com.tianqiyubao.sunnyweather.SunnyWeatherApplication;
import com.tianqiyubao.sunnyweather.logic.model.PlaceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceService {
    @GET("v2/place?token="+ SunnyWeatherApplication.TOKEN+"&lang=zh_CN")
    Call<PlaceResponse> searchPlaces(@Query("query") String query);
}
