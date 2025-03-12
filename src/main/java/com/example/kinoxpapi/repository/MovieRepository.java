package com.example.kinoxpapi.repository;

import com.example.kinoxpapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByMovieTitle(String movieTitle);
}
