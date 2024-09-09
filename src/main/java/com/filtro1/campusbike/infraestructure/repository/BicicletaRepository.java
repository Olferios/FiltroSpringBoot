package com.filtro1.campusbike.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro1.campusbike.domain.entities.Bicicleta;

public interface BicicletaRepository  extends JpaRepository<Bicicleta, Long> {

}
