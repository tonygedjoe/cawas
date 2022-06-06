package com.tg.cawas.service;

import com.tg.cawas.entity.Meeting;
import com.tg.cawas.repository.MeetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InitMeetingsTest {

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void initMeetingsTest() {
        Meeting m1 = new Meeting();
        m1.setMeetingDate(LocalDateTime.now().minusDays(10));
        m1.setMeetingTitle("Old meeting");
        m1.setMeetingDescription("This is some description.");
        m1.setMeetingImageUrl("/SoulNebula1.jpg");
        m1.setMeetingSpeaker("");
        m1.setMeetingSpeakerBio("");

        m1 = meetingRepository.save(m1);

        Meeting m2 = new Meeting();
        m2.setMeetingDate(LocalDateTime.now().plusDays(10));
        m2.setMeetingTitle("Next meeting");
        m2.setMeetingDescription("This is some other description.");
        m2.setMeetingImageUrl("/moon.jpg");
        m2.setMeetingSpeaker("");
        m2.setMeetingSpeakerBio("");

        m2 = meetingRepository.save(m2);


        return;
    }

    @Test
    public void getNextMeetingTest() {

        List<Meeting> meetingList = meetingRepository.findByMeetingDateGreaterThan(LocalDateTime.now());
        assertTrue(meetingList.size() == 1);
    }
}
