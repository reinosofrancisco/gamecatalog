package com.repositories.gamescatalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.gamescatalog.models.Game;
import com.repositories.gamescatalog.repositories.GameRepository;

@Service
public class GameService {
	
	private final GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}

	public Iterable<Game> getGames() {
		return gameRepository.findAll();
	}

	public Game getGameById(Long id) {
		return gameRepository.findById(id).get();
	}

	public String deleteGameById(Long id) {
		gameRepository.deleteById(id);
		return "Deleted game with ID: " + id;
	}

	//TODO: Update

}
