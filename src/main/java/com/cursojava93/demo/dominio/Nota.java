package com.cursojava93.demo.dominio;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota {


    @Id
    @GeneratedValue
    private long id;


    private String asignatura;


    private int nota;


    private int año;
    
}
