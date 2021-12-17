package com.dataguard.superhero.service;

import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.exception.ObjectNotFoundException;

public interface SuperheroService {


    void create(SuperheroDto superheroDto);


    SuperheroDto getSuperhero(Long superheroId) throws ObjectNotFoundException;
}
