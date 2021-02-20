package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.exception.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.Favorite;

public interface FavoriteDao {

	void addFavorite(String userId, long movieId);

	Favorite getAllFavorites(String userId) throws FavoriteEmptyException;

	void removeFavorite(String userId, long movieId) throws FavoriteEmptyException;

}
