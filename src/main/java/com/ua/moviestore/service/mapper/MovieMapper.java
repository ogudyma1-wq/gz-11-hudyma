package com.ua.moviestore.service.mapper;

import com.ua.moviestore.domain.Movie;
import com.ua.moviestore.web.dto.MovieCardDto;
import com.ua.moviestore.web.dto.MovieDetailDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieCardDto toCard(Movie m) {
        return new MovieCardDto(m.getId(), m.getTitle(), m.getDirector(),
                m.getPrice(), m.getPosterUrl());
    }

    public MovieDetailDto toDetail(Movie m) {
        return new MovieDetailDto(m.getId(), m.getTitle(), m.getDirector(), m.getPrice(),
                m.getYear(), m.getDurationMinutes(), m.getGenre(),
                m.getPosterUrl(), m.getDescription());
    }
}
