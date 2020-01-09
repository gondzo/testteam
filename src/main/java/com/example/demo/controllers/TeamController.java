package com.example.demo.controllers;


import com.example.demo.entities.Players;
import com.example.demo.entities.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private TeamRepository repository;

    TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/teams")
    List<Team> all() {
        return repository.findAll();
    }

    @GetMapping("/teams/{id}")
    Team get(@PathVariable long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Team not found"));
    }

    @PostMapping("/teams")
    Team newTeam(@RequestBody Team team) {
        return repository.save(team);
    }

    @GetMapping("/teams/{id}/players")
    List<Players> getPlayers(@PathVariable long id) throws Exception{
        Team t = repository.findById(id).orElseThrow(() -> new Exception("Team not found"));
        return t.getPlayers();
    }
}
