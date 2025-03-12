package com.example.kinoxpapi.controller;

import com.example.kinoxpapi.model.Auditorium;
import com.example.kinoxpapi.model.MovieScreening;
import com.example.kinoxpapi.model.ScreeningTime;
import com.example.kinoxpapi.service.MovieScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class MovieScreeningController {

    @Autowired
    MovieScreeningService movieScreeningService;

    @GetMapping("/showMovieScreenings")
    public List<MovieScreening> getListOfMovieScreenings() {
        System.out.println(movieScreeningService.getListOfMovieScreenings());
        return movieScreeningService.getListOfMovieScreenings();
    }

    @PostMapping("/movieScreening")
    public ResponseEntity<MovieScreening> createMovieScreening(@PathVariable MovieScreening movieScreening) {
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.createMovieScreening(movieScreening);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("deactivateMovieScreening/{movieScreeningId}")
    public ResponseEntity<MovieScreening> deactivateMovieScreening(@PathVariable int movieScreeningId) {
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.deactivateMovieScreening(movieScreeningId);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getScreeningTimeSlots")
    public List<ScreeningTime> getScreeningTimeSlots() {
        return movieScreeningService.getScreeningTimeSlots();
    }


    @PutMapping("updateMovieScreening")
    public ResponseEntity<MovieScreening> updateMovieScreening(@RequestBody MovieScreening movieScreening) {
        Optional<MovieScreening> optionalMovieScreening = movieScreeningService.updateMovieScreening(movieScreening);

        if (optionalMovieScreening.isPresent()) {
            return ResponseEntity.ok(optionalMovieScreening.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    @GetMapping("/movieScreenings/{auditorium}/{date}")
    public List<MovieScreening> getAvailableTimeslots(
            @PathVariable("auditorium") int auditorium, @PathVariable("date") String date){

        return movieScreeningService.getAllMovieScreeningsNotAvailable(auditorium, date);
    }
}


