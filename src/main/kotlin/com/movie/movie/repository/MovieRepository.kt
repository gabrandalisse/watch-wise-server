package com.movie.movie.repository

import com.movie.movie.model.Movie
import com.movie.movie.service.MovieService

interface IRead<T> {
  fun findAll(): List<T>
  suspend fun findOne(id: String): T
}

interface IWrite<T> {
  fun create(t: T): T
  fun update(t: T): T
  fun delete(t: T): T
}

class MovieRepository : IRead<Movie> {
   private val movieService: MovieService = MovieService();

  override fun findAll(): List<Movie> {
    return emptyList()
  }

  override suspend fun findOne(id: String): Movie {
    return this.movieService.requestMovieByTitle(id);
  }
}