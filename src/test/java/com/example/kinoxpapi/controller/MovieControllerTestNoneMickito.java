package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.KinoXpApiApplication;
import com.example.kinoxpapi.model.Movie;
import com.example.kinoxpapi.repository.MovieRepository;
import com.example.kinoxpapi.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@SpringBootTest
public class MovieControllerTestNoneMickito {

    @Autowired
    MovieController movieController;

    @Autowired
    MovieRepository movieRepository;
  
  @Transactional
    @Test
    void deactivateMovie() {
        Movie lionKing = movieRepository.save(new Movie("Lionking", 125, "En meget god film med løver", 12, "URL", true));

        movieController.deactivateMovie(lionKing.getMovieId());
        Optional<Movie> updatedLionKing = movieRepository.findById(lionKing.getMovieId());


        assertFalse(updatedLionKing.get().isInRotation());
    }

}