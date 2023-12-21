package com.repositories.gamescatalog.services;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.gamescatalog.models.Game;
import com.repositories.gamescatalog.repositories.GameRepository;
import com.repositories.gamescatalog.utils.EmailSender;

import jakarta.mail.MessagingException;

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

	public String sendHelloEmail() {
		EmailSender emailSender = new EmailSender();

		//Call the sendEmail method to send an email
		String toEmail = emailSender.getCurrentUsername(); 
		String subject = "Testing Email triggered by Spring Boot from a Controller";
		String body = "Hello from Games Catalog. This is the list of games: ";

		Iterable<Game> games = this.getGames();

		for (Game game : games) {
			body += "\n" + game.toString();
		}

		try {
			emailSender.sendEmail(toEmail, subject, body);
			return "Email sent!";
		} catch (MessagingException | UnsupportedEncodingException e) { 
			return "Failed to send Email - Not sent! - " + e.getMessage();
		}
	}

}
