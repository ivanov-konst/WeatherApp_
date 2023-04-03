package com.example.weatherapp.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource): WeatherRepo {
    override suspend fun getTemperature(): String {
      return weatherRemoteSource.getWeather().main.temperature
    }
}