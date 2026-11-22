package com.ua.moviestore.web;

import com.ua.moviestore.service.MovieService;
import com.ua.moviestore.web.dto.MovieCardDto;
import com.ua.moviestore.web.dto.MovieDetailDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieCardDto> list() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDetailDto getOne(@PathVariable Long id) {
        return movieService.findById(id);
    }
}
