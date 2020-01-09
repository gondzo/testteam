package com.example.demo.repository;

import com.example.demo.entities.Players;
import com.example.demo.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, Long> {

}
