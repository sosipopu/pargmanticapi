package com.pragmantic.managerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pragmantic.managerapi.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
