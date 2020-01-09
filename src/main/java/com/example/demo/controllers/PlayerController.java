package com.example.demo.controllers;


import com.example.demo.entities.Players;
import com.example.demo.entities.Team;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Players> all() {
        return repository.findAll();
    }

    @GetMapping("/players/{id}")
    Players get(@PathVariable long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Player not found"));
    }

    @PostMapping("/players")
    Players newPlayer(@RequestBody Players player) {
        return repository.save(player);
    }

    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/players/{id}")
    Players updatePlayer(@PathVariable Long id, @RequestBody Players newPlayer) throws Exception {
        return repository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setAge(newPlayer.getAge());
                    player.setGoals(newPlayer.getGoals());
                    return repository.save(player);
                })
                .orElseThrow(() -> new Exception("Player not found"));
    }

}
