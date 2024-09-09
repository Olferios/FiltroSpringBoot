package com.filtro1.campusbike.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro1.campusbike.application.BicicletasService;
import com.filtro1.campusbike.domain.entities.Bicicleta;
import com.filtro1.campusbike.domain.entities.Marca;
import com.filtro1.campusbike.domain.entities.Modelo;
import com.filtro1.campusbike.infraestructure.repository.BicicletaRepository;
import com.filtro1.campusbike.infraestructure.repository.MarcaRepository;
import com.filtro1.campusbike.infraestructure.repository.ModeloRepository;

@Service
public class BicicletaAdapter implements BicicletasService {

    @Autowired
    private BicicletaRepository bicicletaRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public Optional<Bicicleta> findById(Long id) {
        return bicicletaRepository.findById(id); //
    }

    @Override
    public List<Bicicleta> findAll() {
        return bicicletaRepository.findAll(); //
    }

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        if (bicicleta.getMarca() != null) {
            Marca marca = marcaRepository.findById(bicicleta.getMarca().getId())
                    .orElseThrow(() -> new RuntimeException("Marca not found"));
            bicicleta.setMarca(marca);
        }
        if (bicicleta.getModelo() != null) {
            Modelo modelo = modeloRepository.findById(bicicleta.getModelo().getId())
                    .orElseThrow(() -> new RuntimeException("Modelo not found"));
            bicicleta.setModelo(modelo);
        }
        return bicicletaRepository.save(bicicleta);
    }

    @Override
    public void deleteById(Long id) {
        bicicletaRepository.deleteById(id);
    }

    // @Override
    // public Bicicleta update(Bicicleta bicicleta) {
    // return bicicletaRepository.save(bicicleta);
    // }
    @Override
    public Bicicleta update(Bicicleta bicicleta) {
        if (bicicleta.getMarca() != null) {
            Marca marca = marcaRepository.findById(bicicleta.getMarca().getId())
                    .orElseThrow(() -> new RuntimeException("Marca not found"));
            bicicleta.setMarca(marca);
        }
        if (bicicleta.getModelo() != null) {
            Modelo modelo = modeloRepository.findById(bicicleta.getModelo().getId())
                    .orElseThrow(() -> new RuntimeException("Modelo not found"));
            bicicleta.setModelo(modelo);
        }
        Bicicleta bicicletaExistente = bicicletaRepository.findById(bicicleta.getId())
                .orElseThrow(() -> new RuntimeException("Bicicleta not found"));
        bicicletaExistente.setMarca(bicicleta.getMarca());
        bicicletaExistente.setModelo(bicicleta.getModelo());
        // Actualiza otros atributos si es necesario
        return bicicletaRepository.save(bicicletaExistente);
    }

    @Override
    public boolean existById(Long id) {
        return bicicletaRepository.existsById(id);
    }

}
