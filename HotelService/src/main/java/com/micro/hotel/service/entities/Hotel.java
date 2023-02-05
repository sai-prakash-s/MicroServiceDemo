package com.micro.hotel.service.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String about;
}
