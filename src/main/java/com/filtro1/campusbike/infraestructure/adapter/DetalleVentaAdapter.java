package com.filtro1.campusbike.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro1.campusbike.application.DetallesVentasService;
import com.filtro1.campusbike.domain.entities.DetalleVenta;
import com.filtro1.campusbike.infraestructure.repository.DetalleVentaRepository;

@Service
public class DetalleVentaAdapter implements DetallesVentasService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public Optional<DetalleVenta> findById(Long id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deleteById(Long id) {
        detalleVentaRepository.deleteById(id);
    }

    @Override
    public DetalleVenta update(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public boolean existById(Long id) {
        return detalleVentaRepository.existsById(id);
    }

}
