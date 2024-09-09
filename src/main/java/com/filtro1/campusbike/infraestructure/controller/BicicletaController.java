package com.filtro1.campusbike.infraestructure.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtro1.campusbike.application.BicicletasService;
import com.filtro1.campusbike.domain.entities.Bicicleta;

@RestController
@RequestMapping (value =("api/bicicletas"))
public class BicicletaController {

    @Autowired
    private BicicletasService bicicletasService;

    @GetMapping
    public List<Bicicleta> getBicicletas(){
        return bicicletasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Bicicleta> getBicicletaById(@PathVariable Long id){
        Optional<Bicicleta> bicicleta=bicicletasService.findById(id);
        return bicicleta.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping ("/create")
    public ResponseEntity <Bicicleta> createBicicleta(@RequestBody Bicicleta bicicleta){
        Bicicleta newBicicleta = bicicletasService.save(bicicleta);
        return new ResponseEntity<>(newBicicleta,HttpStatus.CREATED);
        
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteBicicleta (@PathVariable Long id){
        if(!bicicletasService.existById(id)){
            return ResponseEntity.notFound().build();
        }bicicletasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity <Bicicleta> updateBicicleta (@PathVariable Long id, Bicicleta bicicleta){
        if(!bicicletasService.existById(id)){
            return ResponseEntity.notFound().build();
        }bicicleta.setId(id);
        Bicicleta savedBicicleta=bicicletasService.save(bicicleta);
        return ResponseEntity.ok(savedBicicleta);
    }
    

}
