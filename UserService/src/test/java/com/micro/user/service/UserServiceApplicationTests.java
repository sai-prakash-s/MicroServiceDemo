package com.micro.user.service;

import com.micro.user.service.entities.Rating;
import com.micro.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	public void createRating() {
//		Rating rating = Rating.builder()
//							.ratingId("122")
//									.userId("456")
//											.hotelId("789")
//													.feedback("Good Hotel")
//															.build();
//		ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
//		System.out.println(ratingResponseEntity.getBody());
//		System.out.println(ratingResponseEntity.getStatusCode());
//		System.out.println(ratingResponseEntity.getStatusCodeValue());
//		System.out.println("New Rating Created");
//	}

//	@Test - Will throw error because update Rating is not implemented in Rating Service Microservice
//	public void updateRating() {
//		Rating rating = Rating.builder()
//				.ratingId("122")
//				.userId("567")
//				.hotelId("345")
//				.feedback("Oldest Good Hotel")
//				.build();
//		ResponseEntity<Rating> ratingResponseEntity = ratingService.updateRating("122", rating);
//		System.out.println(ratingResponseEntity.getBody());
//		System.out.println(ratingResponseEntity.getStatusCode());
//		System.out.println(ratingResponseEntity.getStatusCodeValue());
//		System.out.println("Rating updated");
//	}
}
