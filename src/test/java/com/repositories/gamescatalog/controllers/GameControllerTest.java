package com.repositories.gamescatalog.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repositories.gamescatalog.models.Game;
import com.repositories.gamescatalog.services.GameService;

@WebMvcTest(GameController.class)
class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private GameService gameService;

	@Test
	void whenValidInput_thenReturns200() throws Exception {
		Game game = new Game(23L,
				"SOTC",
				"Adventure", 
				"Ps2", 
				"2005-10-18", 
				"http2.mlstatic.com/D_NQ_NP_602905-MLA50824568916_072022-O.webp", 
				"Team Ico", 
				"Sony"
		);

		// Mock the behavior of the gameService when saveGame is called so that it returns 'game'
		Mockito.when(gameService.saveGame(Mockito.any(Game.class))).thenReturn(game);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/addGame")
			.accept("application/json")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(game));

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		// Check that Response is 200 OK
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}


