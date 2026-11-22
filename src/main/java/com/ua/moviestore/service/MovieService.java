package com.ua.moviestore.service;

import com.ua.moviestore.web.dto.MovieCardDto;
import com.ua.moviestore.web.dto.MovieDetailDto;

import java.util.List;

public interface MovieService {
    List<MovieCardDto> findAll();
    MovieDetailDto findById(Long id);
}
