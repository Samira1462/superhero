package com.dataguard.superhero.dto.mapper;


import com.dataguard.superhero.dto.SuperheroDto;
import com.dataguard.superhero.model.entity.Superhero;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SuperheroMapper {

    Superhero SuperheroDtoToSuperhero(SuperheroDto superhero);

    SuperheroDto SuperheroToSuperheroDto(Superhero superhero);

}
