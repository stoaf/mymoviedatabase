package de.dhbw.ravensburg.wp.mymoviedatabase;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Award;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Cast;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Director;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.AwardRepository;
import de.dhbw.ravensburg.wp.mymoviedatabase.repository.MovieRepository;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@Slf4j
public class ManualTestBean {
    // Vorsicht diese Klasse ist nur für Übungszwecke,
    // sie sollte nie in einer produktiven Applikation sein

    MovieRepository movieRepository;
    MovieService movieService;
    AwardRepository awardRepository;

    ManualTestBean(MovieRepository movieRepository, MovieService movieService, AwardRepository awardRepository)
    {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
        this.awardRepository = awardRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){

        //Filme anlegen
        Movie movie_1 = new Movie("Interstellar",
                2.49,
                LocalDate.of(2014,11,6),
                "A team of explorers travel through a wormhole in space in an attempt to " +
                        "ensure humanity's survival.",
                "https://www.imdb.com/video/imdb/vi1586278169?playlistId=tt0816692&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg",
                8.6);

        Movie movie_2 = new Movie("The Dark Knight Rises",
                2.44,
                LocalDate.of(2012,7,26),
                "Eight years after the Joker's reign of anarchy, Batman, with the help of the enigmatic " +
                        "Catwoman, is forced from his exile to save Gotham City from the brutal guerrilla terrorist Bane.",
                "https://www.imdb.com/video/imdb/vi2376312089?playlistId=tt1345836&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/8/83/Dark_knight_rises_poster.jpg",
                8.4);

        Movie movie_3 = new Movie("The Dark Knight",
                2.32,
                LocalDate.of(2012,7,26),
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman " +
                        "must accept one of the greatest psychological and physical tests of his ability to fight injustice. ",
                "https://www.imdb.com/video/imdb/vi324468761?playlistId=tt0468569&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg",
                9.0);

        Movie movie_4 = new Movie("Matrix",
                2.16,
                LocalDate.of(2012,7,26),
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers " +
                        "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence",
                "https://www.imdb.com/video/imdb/vi1032782617?playlistId=tt0133093&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg",
                8.7);

        Movie movie_5 = new Movie("Star Wars: Der Aufstieg Skywalkers",
                2.21,
                LocalDate.of(2019,12,18),
                "The surviving members of the resistance face the First Order once again, and the legendary " +
                        "conflict between the Jedi and the Sith reaches its peak bringing the Skywalker saga to its end.",
                "https://www.imdb.com/video/imdb/vi518503961?playlistId=tt2527338&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/a/af/Star_Wars_The_Rise_of_Skywalker_poster.jpg",
                6.6);

        Movie movie_6 = new Movie("Star Wars: Rogue One",
                2.13,
                LocalDate.of(2016,12,15),
                "The daughter of an Imperial scientist joins the Rebel Alliance in a risky move to steal " +
                        "the plans for the Death Star.",
                "https://www.imdb.com/video/imdb/vi830387737?playlistId=tt3748528&ref_=tt_ov_vi",
                "https://upload.wikimedia.org/wikipedia/en/d/d4/Rogue_One%2C_A_Star_Wars_Story_poster.png",
                7.8);
        //----------------------
        //Cast anlegen
        Cast bale = new Cast("Bale", "Christian",LocalDate.of(1974,1,30),
                null,1.83);
        Cast caine = new Cast("Caine", "Michael", LocalDate.of(1933,3,14),
                null, 1.88);
        Cast reeves = new Cast("Reeves", "Keanu", LocalDate.of(1964,9,1),
                null, 1.86);
        Cast mcConaughey = new Cast("McConaughey", "Matthew ", LocalDate.of(1969, 11, 4),
                null, 1.82);
        Cast ridley = new Cast("Ridley", "Daisy", LocalDate.of(1992,4,10),
                null, 1.7);
        Cast jones = new Cast("Jones", "Felicity", LocalDate.of(1983,10,17),
                null, 1.6);


        //----------------------
        //Director anlegen
        Director nolan = new Director("Nolan", "Christopher", LocalDate.of(1970,7,30),
                null);
        Director wachowski = new Director("Wachowski", "Lana", LocalDate.of(1965,6,1),
                null);
        Director abrams = new Director("Abrams", "J.J.", LocalDate.of(1966,6,27),
                null);
        Director edwards = new Director("Edwards", "Gareth", LocalDate.of(1975,7,1),
                null);

        //----------------------
        //Filme zuordnen
        movie_1.setDirector(nolan);
        movie_1.setInvolvedCast(Arrays.asList(mcConaughey));

        movie_2.setDirector(nolan);
        movie_2.setInvolvedCast(Arrays.asList(bale, caine));

        movie_3.setDirector(nolan);
        movie_3.setInvolvedCast(Arrays.asList(bale, caine));

        movie_4.setDirector(wachowski);
        movie_4.setInvolvedCast(Arrays.asList(reeves));

        movie_5.setDirector(abrams);
        movie_5.setInvolvedCast(Arrays.asList(ridley));

        movie_6.setDirector(edwards);
        movie_6.setInvolvedCast(Arrays.asList(jones));


        //--------------------------------
        //Award anlegen
        Award oscar_1 = new Award("Oscar", "Best Picture", 2008);
        Award oscar_2 = new Award("Oscar", "Best Performance by an Actor in a Supporting Role", 2009);
        Award oscar_3 = new Award("Oscar", "Best Achievement in Sound Editing", 2009);
        Award oscar_4 = new Award("Oscar", "Best Effects, Visual Effects", 2000);

        //Award zuordnen
        oscar_1.setMovie(movie_1);
        movie_1.setAwards(Arrays.asList(oscar_1));
        oscar_2.setMovie(movie_3);
        oscar_3.setMovie(movie_3);
        movie_3.setAwards(Arrays.asList(oscar_2, oscar_3));
        oscar_4.setMovie(movie_4);
        movie_4.setAwards(Arrays.asList(oscar_4));

        //Filme speichern
        this.movieRepository.saveAll(Arrays.asList(movie_1,movie_2,movie_3,movie_4,movie_5,movie_6));

        //Beispielabfragen
        log.info("----- Test Query 1: IMDB Rating > 7 -----");
        this.movieRepository.findByImdbRatingGreaterThan(7).
                forEach(movie->log.info(movie.getTitle()));
        log.info("----- Test Query 2: Title contains 'Star' -----");
        this.movieRepository.findByTitleContaining("Star").
                forEach(movie->log.info(movie.getTitle()));

//        log.info("-----------movie cast--------");
//        this.movieService.getCastOfMovie("Rises").
//                forEach(cast -> log.info(cast));


    }
}
