package com.palette_api.controller;

import com.palette_api.dto.PintorDTO;
import com.palette_api.model.PintorModel;
import com.palette_api.service.PintorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pintores")
public class PintorController {

    @Autowired
    private PintorService pintorService;

    @PostMapping
    public ResponseEntity<PintorModel> criar(@RequestBody PintorDTO pintorDTO) {
        PintorModel criado = pintorService.criar(pintorDTO);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PintorModel> atualizar(@PathVariable Long id, @RequestBody PintorDTO pintorDTO) {
        PintorModel atualizado = pintorService.atualizar(id, pintorDTO);
        return ResponseEntity.ok(atualizado);
    }


    @GetMapping
    public List<PintorModel> listar() {
        return pintorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PintorModel> buscar(@PathVariable Long id) {
        PintorModel pintor = pintorService.buscarPorId(id);
        return ResponseEntity.ok(pintor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pintorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
