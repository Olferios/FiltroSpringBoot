package com.filtro1.campusbike.application;

import java.util.List;
import java.util.Optional;

import com.filtro1.campusbike.domain.entities.DetalleVenta;


public interface DetallesVentasService {
    Optional <DetalleVenta> findById(Long id);
    List <DetalleVenta> findAll();
    DetalleVenta save(DetalleVenta detalleVenta);
    void deleteById(Long id);
    DetalleVenta update (DetalleVenta detalleVenta);
    boolean existById(Long id);

}
