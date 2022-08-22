package com.mesintech.dvdstore.web.api;

import com.mesintech.dvdstore.entity.Movie;
import com.mesintech.dvdstore.service.IMovieServiceInterface;
import com.mesintech.dvdstore.web.entity.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    public IMovieServiceInterface getMovieService() {
        return movieService;
    }

    @Autowired
    public void setMovieService(IMovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private IMovieServiceInterface movieService;

    @GetMapping
    public Iterable<Movie> list() {
        return movieService.getMovieList();
    }

    @PostMapping("")
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);

    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id) {
        return movieService.getMovieById(id);

    }
}
