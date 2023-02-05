package com.micro.rating.services.impl;

import com.micro.rating.entities.Rating;
import com.micro.rating.repositories.RatingRepository;
import com.micro.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    /**
     * @param rating
     * @return rating object stored in DB
     */
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    /**
     * @return all the ratings
     */
    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    /**
     * @param userId
     * @return all the ratings available for the userId
     */
    @Override
    public List<Rating> getAllRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    /**
     * @param hotelId
     * @return all the ratings available for the hotelId
     */
    @Override
    public List<Rating> getAllRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
