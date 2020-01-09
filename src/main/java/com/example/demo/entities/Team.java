package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String foundationYear;
    @OneToMany
    private List<Players> players;
    
}
