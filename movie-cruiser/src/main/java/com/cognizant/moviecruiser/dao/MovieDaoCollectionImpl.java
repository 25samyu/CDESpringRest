package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.model.Movie;

@Component
public class MovieDaoCollectionImpl implements MovieDao {
	private static Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	private List<Movie> movieList;

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public MovieDaoCollectionImpl() {
		LOGGER.debug("Inside MenuItemDaoCollectionImpl constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("moviecruiser.xml");
		this.movieList = (ArrayList<Movie>) context.getBean("movies");

	}

	public List<Movie> getMovieListAdmin() {
		LOGGER.info("START");
		LOGGER.info("END");
		return movieList;
	}

	public List<Movie> getMovieListCustomer() {
		LOGGER.info("START");
		List<Movie> list = new ArrayList<Movie>();
		for (Movie movie : movieList) {
			if (((movie.getDateOfLaunch()).equals(new Date()))
					|| (movie.getDateOfLaunch()).before(new Date()) && movie.isActive()) {
				list.add(movie);
			}
		}
		LOGGER.info("END");
		return list;
	}

	public void modifyMovie(Movie movie) {
		LOGGER.info("START");
		for (Movie movieInList : movieList) {
			if (movie.equals(movieInList)) {
				movieList.remove(movieInList);
				movieList.add(movie);
				break;
			}
		}
		LOGGER.info("END");

	}

	public Movie getMovie(long movieId) {
		LOGGER.info("START");
		for (Movie movieInList : movieList) {
			if (movieId == movieInList.getId()) {
				LOGGER.info("END");
				return movieInList;
			}
		}
		LOGGER.info("END");
		return null;
	}

}
