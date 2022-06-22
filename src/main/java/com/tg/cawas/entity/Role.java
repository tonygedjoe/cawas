package com.tg.cawas.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="approle")
public class Role {

    public Role(String rolename, String roledescription) {

        this.rolename = rolename;
        this.roledescription = roledescription;

    }

    public Role() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    private String rolename;
    private String roledescription;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
