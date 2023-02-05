package com.micro.user.service.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private int age;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
