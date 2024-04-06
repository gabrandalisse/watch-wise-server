package com.movie.movie.controller

import com.movie.movie.model.Movie
import com.movie.movie.repository.MovieRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/movie")
class MovieController {
  private val movieRepository: MovieRepository = MovieRepository()

  @GetMapping()
  suspend fun getMovieByTitle(@RequestParam title: String): Movie {
    val movie = this.movieRepository.findOne(title)
    return movie
  }
}
