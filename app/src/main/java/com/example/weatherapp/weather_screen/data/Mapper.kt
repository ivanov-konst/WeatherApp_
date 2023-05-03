package com.example.weatherapp.weather_screen.data

import com.example.weatherapp.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherapp.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.main.temperature
)
