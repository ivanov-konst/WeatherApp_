package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherapp.weather_screen.ui.UiEvent
import com.example.weatherapp.weather_screen.ui.ViewState
import com.example.weatherapp.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

   private val viewModel: WeatherScreenViewModel by viewModel()
   private val textViewHello: TextView by lazy { findViewById(R.id.tvHellow) }
   private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
   private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    viewModel.viewState.observe(this, ::render)

        val textViewHello = findViewById<TextView>(R.id.tvHellow)
        fabWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }
    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        textViewHello.text = "${viewState.title} ${viewState.temperature}"
    }
}