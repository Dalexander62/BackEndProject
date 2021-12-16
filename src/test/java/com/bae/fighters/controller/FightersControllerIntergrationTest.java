package com.bae.fighters.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import com.bae.fighters.domain.Fighter;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:ufc_fighters-schema.sql",
		"classpath:ufc_fighters-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test")
public class FightersControllerIntergrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() throws Exception {
		assertThat(mockMVC).isNotNull();
	}

	@Test
	void testCreate() throws Exception {

		Fighter testGame = new Fighter("Charles Oliveria", "Lightweight", "Brazil");

		String testGameAsJSON = this.mapper.writeValueAsString(testGame);

		RequestBuilder request = post("/createFighter").contentType(MediaType.APPLICATION_JSON).content(testGameAsJSON);
		System.out.println(testGame);
		System.out.println(testGameAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		Fighter testCreatedFighter = new Fighter("Charles Oliveria", "Lightweight", "Brazil");
		testCreatedFighter.setId(2);
		String testCreatedGameAsJSON = this.mapper.writeValueAsString(testCreatedFighter);

		ResultMatcher checkBody = content().json(testCreatedGameAsJSON);

		this.mockMVC.perform(request).andExpect(checkBody).andExpect(checkStatus);

	}

	@Test
	void testGetAllFighters() throws Exception {

		RequestBuilder request = get("/getAllFighters");

		Fighter testFighter = new Fighter("Charles Oliveria", "Lightweight", "Brazil");
		testFighter.setId(1);

		List<Fighter> testFighters = new ArrayList<Fighter>();
		testFighters.add(testFighter);

		System.out.println(testFighters);
		String testFightersJSON = this.mapper.writeValueAsString(testFighters);

		ResultMatcher checkStatus = status().is(200);
		ResultMatcher checkBody = content().json(testFightersJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testUpdateFighter() throws Exception {

		int id = 1;
		Fighter fighter = new Fighter(id, "Charles Oliveria", "Lightweight", "Brazil");

		String fighterAsJSON = this.mapper.writeValueAsString(fighter);
		System.out.println("Hello");

		RequestBuilder request = put("/updateFighter/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(fighterAsJSON);
		System.out.println("Hello");
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(fighterAsJSON);
		System.out.println("Hello");
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {

		RequestBuilder request = delete("/deleteFighter/1");

		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Fighter at index 1 has been deleted!");

		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testFighterById() throws Exception {
		RequestBuilder request = get("/getFighterById/1");

		ResultMatcher checkStatus = status().isOk();

		Fighter testFighter = new Fighter(1, "Charles Oliveria", "Lightweight", "Brazil");

		String testFighterAsJSON = this.mapper.writeValueAsString(testFighter);

		ResultMatcher checkBody= content().json(testFighterAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testFindByName() throws Exception {
		RequestBuilder request = get("/getByName/Charles Oliveria");

		ResultMatcher checkStatus = status().isOk();

		List<Fighter> testFighters = List.of(new Fighter(1, "Charles Oliveria", "Lightweight", "Brazil"));

		String testFighterAsJSON = this.mapper.writeValueAsString(testFighters);

		ResultMatcher checkBody = content().json(testFighterAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testFindByDivison() throws Exception {
		RequestBuilder request = get("/getByDivision/Charles Oliveria");

		ResultMatcher checkStatus = status().isOk();

		List<Fighter> testFighters = List.of(new Fighter(1, "Charles Oliveria", "Lightweight", "Brazil"));

		String testFighterAsJSON = this.mapper.writeValueAsString(testFighters);

		ResultMatcher checkBody = content().json(testFighterAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testFindByCountry() throws Exception {
		RequestBuilder request = get("/getByCountry/Charles Oliveria");

		ResultMatcher checkStatus = status().isOk();

		List<Fighter> testFighters = List.of(new Fighter(1, "Charles Oliveria", "Lightweight", "Brazil"));

		String testFighterAsJSON = this.mapper.writeValueAsString(testFighters);

		ResultMatcher checkBody = content().json(testFighterAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
