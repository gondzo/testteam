package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Players {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int goals;
    private int age;

    @ManyToOne
    private Team team;
}
