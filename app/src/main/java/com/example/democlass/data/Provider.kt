package com.example.democlass.data

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Provider {

    val client: HttpClient = HttpClient() {

        //to map json objects returned from the api to a kotlin data class
        install(ContentNegotiation) {
            json(Json {
                //ignores json keys we have not included in our data class
                ignoreUnknownKeys = true
            })
        }
        //a logger to see logging information about every request we make using the client
        install(Logging) {
            level = LogLevel.ALL
        }

    }

}
