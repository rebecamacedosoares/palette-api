package com.palette_api.service;

import com.palette_api.dto.ObraArteDTO;
import com.palette_api.model.ObraArteModel;
import com.palette_api.model.PintorModel;
import com.palette_api.repository.ObraArteRepository;
import com.palette_api.repository.PintorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraArteService {

    @Autowired
    private ObraArteRepository obraArteRepository;

    @Autowired
    private PintorRepository pintorRepository;

    public ObraArteModel criar(ObraArteDTO dto) {
        PintorModel pintor = pintorRepository.findById(dto.getPintorId())
                .orElseThrow(() -> new RuntimeException("Pintor não encontrado"));

        ObraArteModel obra = new ObraArteModel();
        setData(obra, dto, pintor);

        return obraArteRepository.save(obra);
    }

    public ObraArteModel atualizar(Long id, ObraArteDTO dto) {
        ObraArteModel obra = obraArteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        PintorModel pintor = pintorRepository.findById(dto.getPintorId())
                .orElseThrow(() -> new RuntimeException("Pintor não encontrado"));

        setData(obra, dto, pintor);
        return obraArteRepository.save(obra);
    }

    public List<ObraArteModel> listar() {
        return obraArteRepository.findAll();
    }

    public Optional<ObraArteModel> buscarPorId(Long id) {
        return obraArteRepository.findById(id);
    }

    public void deletar(Long id) {
        obraArteRepository.deleteById(id);
    }

    private void setData(ObraArteModel obra, ObraArteDTO dto, PintorModel pintor) {
        obra.setNome(dto.getNome());
        obra.setAnoCriacao(dto.getAnoCriacao());
        obra.setTecnica(dto.getTecnica());
        obra.setPintor(pintor);
    }
}