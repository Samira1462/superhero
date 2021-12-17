package com.dataguard.superhero.service.impl;

import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.dto.mapper.SuperheroMapper;
import com.dataguard.superhero.exception.ObjectNotFoundException;
import com.dataguard.superhero.model.entity.Superhero;
import com.dataguard.superhero.repository.SuperheroRepository;
import com.dataguard.superhero.service.SuperheroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuperheroServiceImpl implements SuperheroService {


    private final SuperheroRepository superheroRepository;
    private final SuperheroMapper mapper;

    @Override
    public void create(SuperheroDto superheroDto) {
        log.info("start add superhero----->");
        Superhero superhero = mapper.SuperheroDtoToSuperhero(superheroDto);
        superheroRepository.saveAndFlush(superhero);
        log.info("end add superhero----->");
    }

    @Override
    public SuperheroDto getSuperhero(Long superheroId) throws ObjectNotFoundException {
        log.info("get data----->");
        Superhero superhero = superheroRepository.findById(superheroId)
                .orElseThrow(() -> new ObjectNotFoundException("Superhero not found for this id :: " + superheroId));
        SuperheroDto superheroDto = mapper.SuperheroToSuperheroDto(superhero);
         return superheroDto;
    }


}
