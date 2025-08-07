package com.example.eventshuffle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventshuffle.model.Vote;
import com.example.eventshuffle.repository.VoteRepo;

@Service
public class VoteService {

    @Autowired
    private VoteRepo voteRepo;

    public Vote addVote(Vote vote, int id) {
        vote.setEventId(id);
        return voteRepo.save(vote);
    }

    public Object getEventVotes(Integer id) {
        List<Vote> votes = voteRepo.findByEventId(id);
        return votes;
    }


}
