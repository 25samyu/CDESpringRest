package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private static Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> getAllMovies() {
		LOGGER.info("START");
		LOGGER.info("END");
		return movieService.getMovieListCustomer();

	}

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable long id) {
		LOGGER.info("START");
		LOGGER.info("END");
		return movieService.getMovie(id);

	}

	@PutMapping()
	public void modifyMenuItem(@RequestBody Movie movie) {
		LOGGER.info("START");
		movieService.modifyMovie(movie);
		LOGGER.info("END");

	}
}
