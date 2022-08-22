package com.mesintech.dvdstore.web.controller;

import com.mesintech.dvdstore.entity.Movie;
import com.mesintech.dvdstore.service.IMovieServiceInterface;
import com.mesintech.dvdstore.web.entity.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private IMovieServiceInterface movieServiceInterface;

    @GetMapping("dvdstore-home")
    public void displayHome() {
    }

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movieForm, Model model) {

    }

    public IMovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    @Autowired
    public void setMovieServiceInterface(IMovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }
}
