package com.cursojava93.demo.persistencia;

import com.cursojava93.demo.dominio.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;

//Dependencia
// <dependency>
// <groupId>org.springframework.boot</groupId>
// <artifactId>spring-boot-starter-data-jpa</artifactId>
// </dependency>
public interface AlumnoJPARepository extends JpaRepository<Alumno, Long> {
    
}
