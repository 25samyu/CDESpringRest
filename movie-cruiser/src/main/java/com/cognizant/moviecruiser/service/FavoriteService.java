package com.cognizant.moviecruiser.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.MovieCruiserApplication;
import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;

@Service("cartService")
public class FavoriteService {
	private static Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);

	@Autowired
	private FavoriteDao favoriteDao;

	public FavoriteDao fgetFvoriteDao() {
		return favoriteDao;
	}

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public void addFavorite(String userId, long movieId) {
		LOGGER.info("START");
		LOGGER.info("END");
		favoriteDao.addFavorite(userId, movieId);
	}

	public Favorite getAllFavorites(String userId) throws FavoriteEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		return favoriteDao.getAllFavorites(userId);

	}

	public void removeFavorite(String userId, long movieId) throws FavoriteEmptyException {
		LOGGER.info("START");
		LOGGER.info("END");
		favoriteDao.removeFavorite(userId, movieId);
	}
}
