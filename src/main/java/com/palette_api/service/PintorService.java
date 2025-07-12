package com.palette_api.service;

import com.palette_api.dto.PintorDTO;
import com.palette_api.exception.RecursoNaoEncontradoException;
import com.palette_api.model.PintorModel;
import com.palette_api.repository.PintorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PintorService {

    @Autowired
    private PintorRepository pintorRepository;

    public PintorModel criar(PintorDTO dto) {
        PintorModel pintor = new PintorModel();
        setData(pintor, dto);
        return pintorRepository.save(pintor);
    }

    public PintorModel atualizar(Long id, PintorDTO dto) {
        PintorModel pintor = buscarPorId(id);
        setData(pintor, dto);
        return pintorRepository.save(pintor);
    }

    public List<PintorModel> listarTodos() {
        return pintorRepository.findAll();
    }

    public PintorModel buscarPorId(Long id) {
        return pintorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pintor com ID " + id + " não encontrado"));
    }

    public void deletar(Long id) {
        PintorModel pintor = buscarPorId(id);
        pintorRepository.delete(pintor);
    }

    private void setData(PintorModel pintor, PintorDTO dto) {
        pintor.setNome(dto.getNome());
        pintor.setDataNascimento(dto.getDataNascimento());
        pintor.setDataFalecimento(dto.getDataFalecimento());
        pintor.setNacionalidade(dto.getNacionalidade());
    }

}
