package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherapp.weather_screen.WeatherInteractor
import com.example.weatherapp.weather_screen.data.WeatherApi
import com.example.weatherapp.weather_screen.data.WeatherApiClient
import com.example.weatherapp.weather_screen.data.WeatherRemoteSource
import com.example.weatherapp.weather_screen.data.WeatherRepoImpl
import com.example.weatherapp.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherScreenPresenter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter =  WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(WeatherApiClient.getApi())
                )
            )
        )

        var weather = ""
        val textViewHello = findViewById<TextView>(R.id.tvHellow)

        GlobalScope.launch {
          withContext(Dispatchers.Main) {
              textViewHello.text = presenter.getWeather()
          }
        }


        textViewHello.text

    }
}