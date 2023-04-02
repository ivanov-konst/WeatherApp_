package com.example.weatherapp.weather_screen

import com.example.weatherapp.weather_screen.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    fun  getWeather(): String {
        return  weatherRepo.getTemperature()
    }
}