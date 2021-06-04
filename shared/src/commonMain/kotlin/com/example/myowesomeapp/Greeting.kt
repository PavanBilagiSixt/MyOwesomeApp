package com.example.myowesomeapp

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    val httpClient = HttpClient()

    suspend fun greeting(): String {
        return getLocalisedHelloText()
    }

    private suspend fun getLocalisedHelloText(): String {
        val response: HttpResponse =
            httpClient.get("https://gitcdn.link/cdn/KaterinaPetrova/greeting/7d47a42fc8d28820387ac7f4aaf36d69e434adc1/greetings.json")
        return response.readText()
    }
}