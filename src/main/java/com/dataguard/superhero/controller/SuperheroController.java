package com.dataguard.superhero.controller;

import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.exception.ObjectNotFoundException;
import com.dataguard.superhero.facade.SuperheroFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class SuperheroController {


    private final SuperheroFacade superheroFacade;

    @PostMapping( "/create")
    public ResponseEntity add(@Valid @RequestBody SuperheroDto superheroDto)  {
        log.info("add superhero------->");
        superheroFacade.create(superheroDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/retrieve/{superheroId}")
    public ResponseEntity<SuperheroDto> getSuperhero(@PathVariable("superheroId") Long superheroId) throws ObjectNotFoundException {
        log.info("get superhero------->");
        return ResponseEntity.ok(superheroFacade.getSuperhero(superheroId));
    }
}
