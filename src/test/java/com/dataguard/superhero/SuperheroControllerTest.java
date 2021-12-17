package com.dataguard.superhero;

import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.service.SuperheroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperheroControllerTest {
    @Mock
    private SuperheroService superheroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPostCarPlug(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(post("/api/v1/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(createSuperheroDto())))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSuperhero(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/api/v1/retrieve/1"))
              .andExpect(status().isOk());
    }

    @Test
    public void testGetSuperheroThrowsObjectNotFoundException(@Autowired MockMvc mvc) throws Exception {
        doThrow(RuntimeException.class).when(superheroService).getSuperhero(anyLong());
        mvc.perform(get("/api/v1/retrieve/2")).andExpect(status().isNotFound());
    }

    public static SuperheroDto createSuperheroDto() {
        SuperheroDto superheroDto = new SuperheroDto();
        superheroDto.setAlias("Captain Marvel");
        superheroDto.setName("Carol Danvers");
        superheroDto.setOrigin("Exposed to Space Stone reactor overloa");
        List<String> associations = Stream.of("war-machine", "avengers", "jarvis", "thanos", "pepper-potts").collect(Collectors.toList());
        superheroDto.setAssociations(associations);
        List<String> powers = Stream.of("genius-intelligence", "wealth").collect(Collectors.toList());
        superheroDto.setPowers(powers);
        List<String> weapons = Stream.of("").collect(Collectors.toList());
        superheroDto.setWeapons(weapons);
        return superheroDto;
    }

}
