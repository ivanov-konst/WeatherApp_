package com.example.weatherapp.weather_screen.ui

import com.example.weatherapp.Base.Event

data class ViewState(
    val isLoading: Boolean,
    val title: String,
    val temperature: String
)

sealed class UiEvent() : Event {
    object OnButtonClicked: UiEvent()
}

sealed class DataEvent() : Event {
    data class OnWeatherFetchSucceed(val temperature: String): DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable): DataEvent()
}