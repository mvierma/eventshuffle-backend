package com.example.eventshuffle.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventVote {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private List<String> names;

}
