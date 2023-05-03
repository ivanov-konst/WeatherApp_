package com.example.weatherapp.weather_screen.data

import com.example.weatherapp.weather_screen.ui.model.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource): WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
      return weatherRemoteSource.getWeather().toDomain()
    }
}