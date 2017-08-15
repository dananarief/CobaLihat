package com.dananarief.android.cobalihat.Retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dananarief on 15/08/2017.
 */

public class WeatherClient {
    public static final String BASE_URL="https://api.openweathermap.org/data/";
    public static Retrofit sRetrofit = null;

    public static Retrofit getWeatherResponse(){
        if(sRetrofit==null){
            sRetrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sRetrofit;
    }

}
