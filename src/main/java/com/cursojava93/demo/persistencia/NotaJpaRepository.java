package com.cursojava93.demo.persistencia;

import com.cursojava93.demo.dominio.Nota;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaJpaRepository extends JpaRepository<Nota, Long>{
    
}
