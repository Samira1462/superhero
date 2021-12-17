package com.dataguard.superhero.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_Superhero")
public class Superhero{

    @Id
    @GeneratedValue(generator = "incremental_id")
    @GenericGenerator(name = "incremental_id", strategy = "increment")
    @Column(name = "ID", nullable = false, unique = true, updatable = false)
    private Long id;

    @JsonProperty
    @Column(name = "ALIAS", length = 50, nullable = false)
    @NotBlank(message = "Alias is mandatory")
    private String alias;

    @JsonProperty
    @Column(name = "NAME", length = 50, nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;


    @JsonProperty
    @ElementCollection(targetClass=String.class)
    @Column(name="POWERS")
    private List<String> powers;

    @JsonProperty
    @ElementCollection(targetClass=String.class)
    @Column(name="WEAPONS")
    private List<String> weapons;

    @JsonProperty
    @Column(name = "ORIGIN", length = 50, nullable = false)
    private String origin;

    @JsonProperty
    @ElementCollection(targetClass=String.class)
    @Column(name="ASSOCIATIONS")
    private List<String> associations;
}