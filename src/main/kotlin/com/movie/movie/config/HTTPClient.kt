package com.movie.movie.config

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class HTTPClient {
  companion object {
    private lateinit var instance: HttpClient

    fun getInstance(): HttpClient {
      if (!::instance.isInitialized) {
        instance = HttpClient {
          install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
              ignoreUnknownKeys = true
            })
          }
        }
      }

      return instance
    }
  }
}