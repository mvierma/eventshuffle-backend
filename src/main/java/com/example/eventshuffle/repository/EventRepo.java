package com.example.eventshuffle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventshuffle.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {


}
