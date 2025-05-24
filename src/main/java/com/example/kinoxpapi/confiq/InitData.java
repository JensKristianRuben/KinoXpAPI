package com.example.kinoxpapi.confiq;

import com.example.kinoxpapi.model.*;
import com.example.kinoxpapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final SeatRepository seatRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final MovieScreeningRepository movieScreeningRepository;
    private final SeatReservationRepository seatReservationRepository;
    private final BookingRepository bookingRepository;

    public InitData(MovieRepository movieRepository, SeatRepository seatRepository,
                    AuditoriumRepository auditoriumRepository, MovieScreeningRepository movieScreeningRepository,
                    SeatReservationRepository seatReservationRepository, BookingRepository bookingRepository) {
        this.movieRepository = movieRepository;
        this.seatRepository = seatRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieScreeningRepository = movieScreeningRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Create Auditoriums and Seats
        //    - Auditoriums must be created first, as seats need to be associated with them.

        // 2. Create Movies
        //    - Movies must be created before screenings, as screenings are linked to specific movies.

        // 3. Create Movie Screenings and associate them with a movie and an auditorium
        //    - Movie screenings require both a movie and an auditorium to be linked.

        // 4. Create Seat Reservations and associate them with a Movie Screening and a specific Seat
        //    - Seat reservations need a movie screening and a seat to be valid.

        // 5. Create Bookings and link them to Seat Reservations
        //    - Bookings can be created independently, but must be connected to seat reservations.


        Auditorium auditorium1 = auditoriumRepository.save(new Auditorium(1, 1));

        Auditorium auditorium2 = auditoriumRepository.save(new Auditorium(2, 2));


        List<Seat> smallRoom = new ArrayList<>();
        List<Seat> bigRoom = new ArrayList<>();
        smallRoom.addAll(generateSeats(auditorium1, 20, 12));
        bigRoom.addAll(generateSeats(auditorium2, 25, 16));


        seatRepository.saveAll(smallRoom);
        seatRepository.saveAll(bigRoom);

        Movie movie1 = new Movie("Inception", 148, "A thief enters dreams to steal secrets.", 13, "https://xl.movieposterdb.com/10_06/2010/1375666/xl_1375666_07030c72.jpg?v=2025-03-07%2009:48:51", true);
        Movie movie2 = new Movie("Mickey 17", 152, "Funny clone movie", 13, "https://poster.ebillet.dk/mickey-17-2025.hd.jpg", true);
        Movie movie3 = new Movie("Interstellar", 169, "A journey beyond our galaxy.", 10, "https://xl.movieposterdb.com/14_09/2014/816692/xl_816692_2beaba6e.jpg?v=2025-03-10%2002:36:44", true);
        Movie movie4 = new Movie("The Dark Knight", 152, "A hero emerges to save Gotham from chaos.", 12, "https://xl.movieposterdb.com/08_06/2008/468569/xl_468569_fe24b125.jpg?v=2025-03-09%2017:30:21", true);
        Movie movie5 = new Movie("Avatar", 162, "A marine joins the fight to protect the Na'vi people on Pandora.", 10, "https://xl.movieposterdb.com/10_08/2009/499549/xl_499549_43475538.jpg?v=2025-03-09%2017:28:28", true);
        Movie movie6 = new Movie("The Matrix", 136, "A hacker discovers the truth about reality.", 15, "https://xl.movieposterdb.com/06_01/1999/0133093/xl_77607_0133093_ab8bc972.jpg?v=2025-03-09%2010:34:01", true);
        Movie movie7 = new Movie("The Shawshank Redemption", 142, "A man finds hope in the unlikeliest of places.", 15, "https://xl.movieposterdb.com/05_03/1994/0111161/xl_8494_0111161_3bb8e662.jpg?v=2025-03-04%2017:32:12", true);
        Movie movie8 = new Movie("Pulp Fiction", 154, "A journey through intersecting lives in LA.", 18, "https://xl.movieposterdb.com/20_10/1994/110912/xl_110912_40e7dce0.jpg?v=2025-03-07%2016:01:27", true);
        Movie movie9 = new Movie("Pigen med Nålen", 154, "", 18, "https://poster.ebillet.dk/PigenMedNaalen-2025citat.hd.jpg", true);
        Movie movie10 = new Movie("The Brutalist", 154, "", 18, "https://poster.ebillet.dk/TheBrutalist-2025.hd.jpg", true);

        MovieScreening movieScreening = new MovieScreening(movie1, ScreeningTime.TIME_10_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening2 = new MovieScreening(movie2, ScreeningTime.TIME_12_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening3 = new MovieScreening(movie3, ScreeningTime.TIME_14_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening4 = new MovieScreening(movie4, ScreeningTime.TIME_16_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening5 = new MovieScreening(movie5, ScreeningTime.TIME_18_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening6 = new MovieScreening(movie6, ScreeningTime.TIME_20_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening7 = new MovieScreening(movie7, ScreeningTime.TIME_22_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening8 = new MovieScreening(movie8, ScreeningTime.TIME_10_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening9 = new MovieScreening(movie9, ScreeningTime.TIME_12_00, LocalDate.now(), false, auditorium1);
        MovieScreening movieScreening1 = new MovieScreening(movie10, ScreeningTime.TIME_12_00, LocalDate.now(), false, auditorium1);


        MovieScreening movieScreening10 = new MovieScreening(movie4, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening11 = new MovieScreening(movie1, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening12 = new MovieScreening(movie2, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening13 = new MovieScreening(movie3, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening14 = new MovieScreening(movie4, ScreeningTime.TIME_16_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening15 = new MovieScreening(movie5, ScreeningTime.TIME_18_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening16 = new MovieScreening(movie6, ScreeningTime.TIME_20_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening17 = new MovieScreening(movie7, ScreeningTime.TIME_22_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening18 = new MovieScreening(movie8, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening19 = new MovieScreening(movie9, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(1), false, auditorium1);
        MovieScreening movieScreening20 = new MovieScreening(movie10, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(1), false, auditorium1);

        MovieScreening movieScreening21 = new MovieScreening(movie1, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening22 = new MovieScreening(movie2, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening23 = new MovieScreening(movie3, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening24 = new MovieScreening(movie4, ScreeningTime.TIME_16_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening25 = new MovieScreening(movie5, ScreeningTime.TIME_18_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening26 = new MovieScreening(movie6, ScreeningTime.TIME_20_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening27 = new MovieScreening(movie7, ScreeningTime.TIME_22_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening28 = new MovieScreening(movie8, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening29 = new MovieScreening(movie9, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(2), false, auditorium1);
        MovieScreening movieScreening30 = new MovieScreening(movie10, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(2), false, auditorium1);

        MovieScreening movieScreening31 = new MovieScreening(movie1, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening32 = new MovieScreening(movie2, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening33 = new MovieScreening(movie3, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening34 = new MovieScreening(movie4, ScreeningTime.TIME_16_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening35 = new MovieScreening(movie5, ScreeningTime.TIME_18_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening36 = new MovieScreening(movie6, ScreeningTime.TIME_20_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening37 = new MovieScreening(movie7, ScreeningTime.TIME_22_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening38 = new MovieScreening(movie8, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening39 = new MovieScreening(movie9, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(3), false, auditorium1);
        MovieScreening movieScreening40 = new MovieScreening(movie10, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(3), false, auditorium1);

        MovieScreening movieScreening41 = new MovieScreening(movie1, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening42 = new MovieScreening(movie2, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening43 = new MovieScreening(movie3, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening44 = new MovieScreening(movie4, ScreeningTime.TIME_16_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening45 = new MovieScreening(movie5, ScreeningTime.TIME_18_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening46 = new MovieScreening(movie6, ScreeningTime.TIME_20_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening47 = new MovieScreening(movie7, ScreeningTime.TIME_22_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening48 = new MovieScreening(movie8, ScreeningTime.TIME_10_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening49 = new MovieScreening(movie9, ScreeningTime.TIME_12_00, LocalDate.now().plusDays(4), false, auditorium1);
        MovieScreening movieScreening50 = new MovieScreening(movie10, ScreeningTime.TIME_14_00, LocalDate.now().plusDays(4), false, auditorium1);


        Seat seat = seatRepository.getById(67);

        SeatReservation seatReservation = new SeatReservation(seat, movieScreening, true);

        Booking booking = new Booking("Miakhalifa69@hotmail.com");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
        movieRepository.save(movie6);
        movieRepository.save(movie7);
        movieRepository.save(movie8);
        movieRepository.save(movie9);
        movieRepository.save(movie10);

        movieScreeningRepository.save(movieScreening);
        movieScreeningRepository.save(movieScreening1);
        movieScreeningRepository.save(movieScreening2);
        movieScreeningRepository.save(movieScreening3);
        movieScreeningRepository.save(movieScreening4);
        movieScreeningRepository.save(movieScreening5);
        movieScreeningRepository.save(movieScreening6);
        movieScreeningRepository.save(movieScreening7);
        movieScreeningRepository.save(movieScreening8);
        movieScreeningRepository.save(movieScreening9);
        movieScreeningRepository.save(movieScreening10);
        movieScreeningRepository.save(movieScreening11);
        movieScreeningRepository.save(movieScreening12);
        movieScreeningRepository.save(movieScreening13);
        movieScreeningRepository.save(movieScreening14);
        movieScreeningRepository.save(movieScreening15);
        movieScreeningRepository.save(movieScreening16);
        movieScreeningRepository.save(movieScreening17);
        movieScreeningRepository.save(movieScreening18);
        movieScreeningRepository.save(movieScreening19);
        movieScreeningRepository.save(movieScreening20);
        movieScreeningRepository.save(movieScreening21);
        movieScreeningRepository.save(movieScreening22);
        movieScreeningRepository.save(movieScreening23);
        movieScreeningRepository.save(movieScreening24);
        movieScreeningRepository.save(movieScreening25);
        movieScreeningRepository.save(movieScreening26);
        movieScreeningRepository.save(movieScreening27);
        movieScreeningRepository.save(movieScreening28);
        movieScreeningRepository.save(movieScreening29);
        movieScreeningRepository.save(movieScreening30);
        movieScreeningRepository.save(movieScreening31);
        movieScreeningRepository.save(movieScreening32);
        movieScreeningRepository.save(movieScreening33);
        movieScreeningRepository.save(movieScreening34);
        movieScreeningRepository.save(movieScreening35);
        movieScreeningRepository.save(movieScreening36);
        movieScreeningRepository.save(movieScreening37);
        movieScreeningRepository.save(movieScreening38);
        movieScreeningRepository.save(movieScreening39);
        movieScreeningRepository.save(movieScreening40);
        movieScreeningRepository.save(movieScreening41);
        movieScreeningRepository.save(movieScreening42);
        movieScreeningRepository.save(movieScreening43);
        movieScreeningRepository.save(movieScreening44);
        movieScreeningRepository.save(movieScreening45);
        movieScreeningRepository.save(movieScreening46);
        movieScreeningRepository.save(movieScreening47);
        movieScreeningRepository.save(movieScreening48);
        movieScreeningRepository.save(movieScreening49);
        movieScreeningRepository.save(movieScreening50);

        seatReservationRepository.save(seatReservation);

        bookingRepository.save(booking);

        seatReservation.setBooking(booking);

        seatReservationRepository.save(seatReservation);
    }

    private List<Seat> generateSeats(Auditorium auditorium, int numRows, int seatsPerRow) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            char rowLetter = (char) ('A' + row);
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat();
                seat.setRowLetter(rowLetter);
                seat.setSeatNumber(seatNum);
                seat.setAuditorium(auditorium);
                seats.add(seat);
            }
        }
        return seats;
    }

}

