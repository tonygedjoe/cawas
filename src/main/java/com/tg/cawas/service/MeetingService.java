package com.tg.cawas.service;

import com.tg.cawas.entity.Meeting;
import com.tg.cawas.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    public List<Meeting> getNextMeetings() {

        List<Meeting> meetingList = meetingRepository.findByMeetingDateGreaterThan(LocalDateTime.now());

        return meetingList;
    }
}
