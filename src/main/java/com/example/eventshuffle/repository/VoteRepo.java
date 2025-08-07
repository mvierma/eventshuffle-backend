package com.example.eventshuffle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventshuffle.model.Vote;

public interface VoteRepo extends JpaRepository<Vote, Integer>{
    List<Vote> findByEventId(Integer id);

    
}
