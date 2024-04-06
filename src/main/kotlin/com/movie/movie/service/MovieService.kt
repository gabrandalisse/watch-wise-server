package com.movie.movie.service

import com.movie.movie.config.HTTPClient
import com.movie.movie.model.Movie
import io.ktor.client.request.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MovieService {
  @Value("\${omdb.api.url}")
  private lateinit var apiUrl: String

  private val client = HTTPClient.getInstance()

  suspend fun requestMovieByTitle(title: String): Movie {
    println("${this.apiUrl}?t=${title}")
    val response: Movie = this.client.get("${this.apiUrl}&t=${title}");
    return response
  }
}