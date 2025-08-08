package com.example.eventshuffle.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Object getSuitableDates(int id) {
        
        List<Vote> votes = voteRepo.findByEventId(id);
        List<List<Date>> dates = new ArrayList<>();
        Map<String, Object> matchingVotes = new HashMap<String, Object>();
        List<String> names = new ArrayList<>();

        // extract voted dates and voter names from all votes
        for (Vote vote : votes) {
            dates.add(vote.getVotes());
            names.add(vote.getName());
        }

        // find dates suitable for all votes
        Set<Date> comparisonSet = new HashSet<>(dates.get(0));
        for (int i = 1; i < dates.size(); i++) {
            comparisonSet.retainAll(dates.get(i));
        }
        matchingVotes.put("date", comparisonSet);
        matchingVotes.put("people", names);

        return matchingVotes;
    }


}
