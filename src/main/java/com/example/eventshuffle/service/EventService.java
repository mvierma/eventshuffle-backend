package com.example.eventshuffle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventshuffle.model.Event;
import com.example.eventshuffle.repository.EventRepo;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;


    public List<Event> getEvents() {
        return eventRepo.findAll();
    }


    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }


    public Event getEventById(int id) {
        return eventRepo.findById(id).orElse(null);
    }

}
