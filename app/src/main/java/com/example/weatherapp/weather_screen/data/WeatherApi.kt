package com.example.weatherapp.weather_screen.data

import com.example.weatherapp.API_KEY
import com.example.weatherapp.weather_screen.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units:String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): WeatherRemoteModel
}