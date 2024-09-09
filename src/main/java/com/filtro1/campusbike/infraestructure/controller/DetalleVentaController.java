package com.filtro1.campusbike.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtro1.campusbike.application.DetallesVentasService;
import com.filtro1.campusbike.domain.entities.Bicicleta;
import com.filtro1.campusbike.domain.entities.DetalleVenta;

@RestController
@RequestMapping("/api/detalle-venta")
public class DetalleVentaController {
    @Autowired
    private DetallesVentasService detallesVentasService;

     @GetMapping
    public List<DetalleVenta> getdDetalleVentas(){
        return detallesVentasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <DetalleVenta> getDetalleVentaById(@PathVariable Long id){
        Optional<DetalleVenta> detalleventa=detallesVentasService.findById(id);
        return detalleventa.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    // create 

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteDetalleVenta (@PathVariable Long id){
        if(!detallesVentasService.existById(id)){
            return ResponseEntity.notFound().build();
        }detallesVentasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity <DetalleVenta> updateDetalleVenta (@PathVariable Long id, DetalleVenta detalleVenta){
        if(!detallesVentasService.existById(id)){
            return ResponseEntity.notFound().build();
        }detalleVenta.setId(id);
        DetalleVenta savedDetalleVenta=detallesVentasService.save(detalleVenta);
        return ResponseEntity.ok(savedDetalleVenta);
    }


}
