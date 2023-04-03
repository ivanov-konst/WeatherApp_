package com.example.weatherapp.weather_screen.ui

import com.example.weatherapp.weather_screen.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {
    suspend fun getWeather(): String {
        return interactor.getWeather()
    }
}