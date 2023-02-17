package com.micro.user.service.services.impl;

import com.micro.user.service.entities.Hotel.Hotel;
import com.micro.user.service.entities.Rating;
import com.micro.user.service.entities.User;
import com.micro.user.service.exceptions.ResourceNotFoundException;
import com.micro.user.service.external.services.HotelService;
import com.micro.user.service.repositories.UserRepository;
import com.micro.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(String userId) {
        User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with the userId " + userId));
        // Earlier it was ArrayList, but internally it's not able to process it due to -> class java.util.LinkedHashMap cannot be cast to class com.micro.user.service.entities.Rating
        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+ user.getUserId(), Rating[].class);

        List<Rating> ratings1 = Arrays.stream(ratings).toList();

        List<Rating> ratingList = ratings1.stream().map(rating -> {

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUserById(String userId) {
        return userRepository.deleteByUserId(userId) > 0 ? "User deleted Successfully" : "User not deleted, please try again";
    }
}
