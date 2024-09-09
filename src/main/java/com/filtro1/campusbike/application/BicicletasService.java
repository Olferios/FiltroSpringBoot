package com.filtro1.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.filtro1.campusbike.domain.entities.Bicicleta;

public interface BicicletasService {
    Optional <Bicicleta> findById(Long id);
    List <Bicicleta> findAll();
    Bicicleta save(Bicicleta bicicleta);
    void deleteById(Long id);
    Bicicleta update (Bicicleta bicicleta);
    boolean existById(Long id);

}
