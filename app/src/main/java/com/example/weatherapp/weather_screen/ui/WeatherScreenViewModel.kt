package com.example.weatherapp.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Base.BaseViewModel
import com.example.weatherapp.Base.Event
import com.example.weatherapp.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor): BaseViewModel<ViewState>()  {

    override fun initialViewState(): ViewState = ViewState(isLoading = false, title = "hello", temperature = "")
    override fun reduce (event: Event, previousState: ViewState): ViewState? {
        when(event) {
                is UiEvent.OnButtonClicked -> {

                    viewModelScope.launch {

                        interactor.getWeather().fold(
                            onError = {
                                processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                            },
                            onSuccess = {
                                processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = it.temperature))
                            }
                        )
                    }
                    return previousState.copy(isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            else -> return null
        }
    }
}