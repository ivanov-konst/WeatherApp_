package com.example.weatherapp.weather_screen

import com.example.weatherapp.Base.Either
import com.example.weatherapp.Base.attempt
import com.example.weatherapp.weather_screen.data.WeatherRepo
import com.example.weatherapp.weather_screen.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    suspend fun  getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}