package com.repositories.gamescatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repositories.gamescatalog.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
