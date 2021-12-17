package com.dataguard.superhero.facade;

import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.exception.ObjectNotFoundException;
import com.dataguard.superhero.service.impl.SuperheroServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class SuperheroFacade {


    private final SuperheroServiceImpl superheroService;

    public void create(SuperheroDto superheroDto) {
        superheroService.create(superheroDto);
    }


    public SuperheroDto getSuperhero(Long superheroId) throws ObjectNotFoundException {
        return superheroService.getSuperhero(superheroId);
    }
}
