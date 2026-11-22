package com.ua.moviestore.repository;

import com.ua.moviestore.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    Movie save(Movie movie);
}
