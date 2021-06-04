package com.example.myowesomeapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myowesomeapp.Greeting
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLocalisedText()

    }

    private fun getLocalisedText() {
        mainScope.launch {
            kotlin.runCatching {
                Greeting().greeting()
            }.onSuccess {
                val tv: TextView = findViewById(R.id.text_view)
                tv.text = it
            }
        }
    }
}
