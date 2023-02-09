package com.javatest.restapi.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatest.restapi.entity.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
    
}
