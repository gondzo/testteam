package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties("team")
    private List<Players> players;

}
