package com.dananarief.android.cobalihat.Retrofit;

import com.dananarief.android.cobalihat.Model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dananarief on 15/08/2017.
 */

public interface WeatherInterface {
    @GET("2.5/weather")
    Call<WeatherResponse> getWetherResponse(@Query("q") String q, @Query("APPID") String APPID);
}
