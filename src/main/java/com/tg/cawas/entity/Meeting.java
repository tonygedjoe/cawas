package com.tg.cawas.entity;

import org.springframework.stereotype.Repository;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="meetingdate")
    private LocalDateTime meetingDate;

    @Column(name="meetingtitle")
    private String meetingTitle;

    @Column(name="meetingdescription")
    private String meetingDescription;

    @Column(name="meetingimageurl")
    private String meetingImageUrl;

    @Column(name="meetingspeaker")
    private String meetingSpeaker;

    @Column(name="meetingspeakerbio")
    private String meetingSpeakerBio;

}
