package com.ua.moviestore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listReturnsFiveSeededMovies() throws Exception {
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[0].title").exists());
    }

    @Test
    void getOneReturnsDetails() throws Exception {
        mockMvc.perform(get("/api/movies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.durationMinutes").exists());
    }

    @Test
    void unknownIdReturns404() throws Exception {
        mockMvc.perform(get("/api/movies/999"))
                .andExpect(status().isNotFound());
    }
}
