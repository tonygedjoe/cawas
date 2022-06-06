package com.tg.cawas.repository;

import com.tg.cawas.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  MeetingRepository extends JpaRepository<Meeting, Integer> {

    public List<Meeting> findByMeetingDateGreaterThan(LocalDateTime now);
}
