package com.cognizant.moviecruiser.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.service.FavoriteService;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
	private static Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	@Autowired
	private FavoriteService favoriteService;

	@PostMapping("/{userId}/{movieId}")
	public void addFavorite(@PathVariable String userId, @PathVariable long movieId) {
		LOGGER.info("START");
		LOGGER.info("END");
		favoriteService.addFavorite(userId, movieId);

	}

	@GetMapping("/{userId}")
	public Favorite getAllCartItem(@PathVariable String userId) throws FavoriteEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		return favoriteService.getAllFavorites(userId);

	}

	@DeleteMapping("/{userId}/{movieId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long movieId) throws FavoriteEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		favoriteService.removeFavorite(userId, movieId);

	}
}
