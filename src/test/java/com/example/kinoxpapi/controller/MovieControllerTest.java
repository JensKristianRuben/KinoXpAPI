package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.model.ScreeningTime;
import com.example.kinoxpapi.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class MovieControllerTest {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieController movieController;

    @Transactional
    @Test
    void deactivateMovie() {
        Movie lionKing = movieRepository.save(new Movie("Lionking", 125, "En meget god film med løver", 12, "URL", true));

        movieController.deactivateMovie(lionKing.getMovieId());
        Optional<Movie> updatedLionKing = movieRepository.findById(lionKing.getMovieId());


        assertFalse(updatedLionKing.get().isInRotation());
    }
}