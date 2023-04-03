package com.example.weatherapp.weather_screen.data

interface WeatherRepo {
    suspend fun getTemperature(): String
}