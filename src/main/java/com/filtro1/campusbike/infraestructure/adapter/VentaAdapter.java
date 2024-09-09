package com.filtro1.campusbike.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro1.campusbike.application.VentasService;
import com.filtro1.campusbike.domain.entities.Bicicleta;
import com.filtro1.campusbike.domain.entities.Venta;
import com.filtro1.campusbike.infraestructure.repository.ClienteRepository;
import com.filtro1.campusbike.infraestructure.repository.VentaRepository;

@Service
public class VentaAdapter implements VentasService {

    @Autowired
    private VentaRepository ventasRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Venta> findById(Long id) {
        return ventasRepository.findById(id);
    }

    @Override
    public List<Venta> findAll() {
        return ventasRepository.findAll();
    }

    // @Override
    // public Venta save(Venta ventas) {
    // return ventasRepository.save(ventas);
    // }
    @Override

    public Venta save(Venta ventas) {
        if (clienteRepository.existsById(ventas.getCliente().getId())) {
            return ventasRepository.save(ventas);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    @Override
    public void deleteById(Long id) {
        ventasRepository.deleteById(id);
    }

    @Override
    public Venta update(Venta ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public boolean existById(Long id) {
        return ventasRepository.existsById(id);
    }

}
