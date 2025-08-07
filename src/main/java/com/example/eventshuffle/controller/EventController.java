package com.example.eventshuffle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventshuffle.model.Event;
import com.example.eventshuffle.model.Vote;
import com.example.eventshuffle.service.EventService;
import com.example.eventshuffle.service.VoteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private VoteService voteService;

    @GetMapping("/api/v1/event/list")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/api/v1/event/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if(event==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Map<String, Object> eventMap = new HashMap<String, Object>();
        eventMap.put("",event);
        eventMap.put("votes", voteService.getEventVotes(event.getId()));

        return new ResponseEntity<>(eventMap, HttpStatus.OK);

    }
    

    @PostMapping("/api/v1/event")
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.addEvent(event);
        Integer eventId = savedEvent.getId();
        Map<String, Object> eventMap = new HashMap<String, Object>();
        eventMap.put("id", eventId);
        
        return new ResponseEntity<>(eventMap, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/event/{id}/vote")
    public ResponseEntity<Object> addVote(@RequestBody Vote vote, @PathVariable int id) {
        voteService.addVote(vote, id);
        Event votedEvent = eventService.getEventById(id);

        Map<String, Object> mergedEvent = new HashMap<String, Object>();
        mergedEvent.put("event",votedEvent);
        mergedEvent.put("vote", vote);

        return new ResponseEntity<>(mergedEvent, HttpStatus.OK);

        
    }

    @GetMapping("/api/v1/event/{id}/results")
    public ResponseEntity<Object> getResults(@PathVariable int id) {
        // TODO
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
}
