package com.filtro1.campusbike.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtro1.campusbike.application.VentasService;
import com.filtro1.campusbike.domain.entities.Bicicleta;
import com.filtro1.campusbike.domain.entities.Venta;

@RestController
@RequestMapping("api/ventas")
public class VentaController {
    @Autowired
    private VentasService ventasService;

    @GetMapping
    public List<Venta> getVentas() {
        return ventasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Optional<Venta> venta = ventasService.findById(id);
        return venta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        try {
            Venta ventaCreada = ventasService.save(venta);
            return ResponseEntity.ok(ventaCreada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        if (!ventasService.existById(id)) {
            return ResponseEntity.notFound().build();
        }
        ventasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, Venta venta) {
        if (!ventasService.existById(id)) {
            return ResponseEntity.notFound().build();
        }
        venta.setId(id);
        Venta savedVenta = ventasService.save(venta);
        return ResponseEntity.ok(savedVenta);
    }

}
