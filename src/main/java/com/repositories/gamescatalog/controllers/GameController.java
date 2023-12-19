package com.repositories.gamescatalog.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repositories.gamescatalog.models.Game;
import com.repositories.gamescatalog.services.GameService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/")
public class GameController {
	
	private GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("/games")
	public Iterable<Game> getGames() {
		return gameService.getGames();
	}

	@GetMapping("/games/{id}")
	public Game getGameById(@PathVariable("id") Long id) {
		return gameService.getGameById(id);
	}

	@GetMapping("/games/{id}/delete")
	public String deleteGameById(@PathVariable("id") Long id) {
		return gameService.deleteGameById(id);
	}

	@PostMapping("/addGame")
	public Game saveGame(@RequestBody Game game) {
		return gameService.saveGame(game);
	}
}
