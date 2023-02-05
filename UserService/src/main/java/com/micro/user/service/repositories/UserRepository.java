package com.micro.user.service.repositories;

import com.micro.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, String> {

    int deleteByUserId(String userId);
}
