package com.cursojava93.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota {

    private String asignatura;
    private int nota;
    private int año;
    
}
