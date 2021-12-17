package com.dataguard.superhero.dto;

import lombok.Data;

import java.util.List;

@Data
public class SuperheroDto {

    private String alias;
    private String name;
    private List<String> powers;
    private List<String> weapons;
    private String origin;
    private List<String> associations;

}

