package com.cursojava93.dominio;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue
    private String id;

//     <dependency>
//     <groupId>org.springframework.boot</groupId>
//     <artifactId>spring-boot-starter-validation</artifactId>
//     </dependency>
    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    private String nombre;

    @Size(min = 3, max = 20, message = "el apellido debe tener mas de 3 letras y menos de 20.")
    private String apellido;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Nota[] notas;
    
}
