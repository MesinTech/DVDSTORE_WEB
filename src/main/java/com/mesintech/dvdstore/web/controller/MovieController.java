package com.mesintech.dvdstore.web.controller;

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
import java.util.Scanner;

@Controller
@RequestMapping("/movie")
public class MovieController {

    public IMovieServiceInterface getMovieService() {
        return movieService;
    }

    @Autowired
    public void setMovieService(IMovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private IMovieServiceInterface movieService;

//    @GetMapping
//    public void displayHome() {
//    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult result) {
        if (result.hasErrors()) {
            return "/add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";

    }
}
