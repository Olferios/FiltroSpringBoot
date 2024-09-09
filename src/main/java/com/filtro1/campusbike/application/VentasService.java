package com.filtro1.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.filtro1.campusbike.domain.entities.Bicicleta;
import com.filtro1.campusbike.domain.entities.Venta;

public interface VentasService {
    Optional <Venta> findById(Long id);
    List <Venta> findAll();
    Venta save(Venta ventas);
    void deleteById(Long id);
    Venta update (Venta ventas);
    boolean existById(Long id);

}
