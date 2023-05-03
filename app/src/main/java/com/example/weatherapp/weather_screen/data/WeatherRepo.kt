package com.example.weatherapp.weather_screen.data

import com.example.weatherapp.weather_screen.ui.model.WeatherModel

interface WeatherRepo {
    suspend fun getTemperature(): WeatherModel
}