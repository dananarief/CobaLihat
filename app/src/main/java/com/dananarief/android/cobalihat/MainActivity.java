package com.dananarief.android.cobalihat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dananarief.android.cobalihat.Model.WeatherResponse;
import com.dananarief.android.cobalihat.Retrofit.WeatherClient;
import com.dananarief.android.cobalihat.Retrofit.WeatherInterface;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText textfield_location;
    TextView text_response;
    TextView text_weather_content;
    ImageButton image_search;
    String keyword;
    WeatherInterface mWeatherInterface;
    String appkey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appkey="52320c776ed8f5a974108d5404688392";

        text = (TextView) findViewById(R.id.title_main);
        text.setText("Please, input the location :)");

        text_response = (TextView) findViewById(R.id.response_main);

        text_weather_content = (TextView) findViewById(R.id.Weather_content);

        image_search = (ImageButton) findViewById(R.id.search_image);

        textfield_location = (EditText) findViewById(R.id.location_input_main);
        textfield_location.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                text_response.setText(charSequence);
                keyword=charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        image_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData(keyword);
            }
        });
    }

    public void getData(String q){
        mWeatherInterface= WeatherClient.getWeatherResponse().create(WeatherInterface.class);
        Call<WeatherResponse> call = mWeatherInterface.getWetherResponse(q,appkey);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                String weather = response.body().getWeather().get(0).getDescription();
                text_weather_content.setText(weather);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}
