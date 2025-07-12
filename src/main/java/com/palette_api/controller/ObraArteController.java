package com.palette_api.controller;

import com.palette_api.dto.ObraArteDTO;
import com.palette_api.model.ObraArteModel;
import com.palette_api.service.ObraArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraArteController {

    @Autowired
    private ObraArteService obraArteService;

    @PostMapping
    public ResponseEntity<ObraArteModel> criar(@RequestBody ObraArteDTO dto) {
        return new ResponseEntity<>(obraArteService.criar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraArteModel> atualizar(@PathVariable Long id, @RequestBody ObraArteDTO dto) {
        return ResponseEntity.ok(obraArteService.atualizar(id, dto));
    }

    @GetMapping
    public List<ObraArteModel> listar() {
        return obraArteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraArteModel> buscarPorId(@PathVariable Long id) {
        return obraArteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        obraArteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}