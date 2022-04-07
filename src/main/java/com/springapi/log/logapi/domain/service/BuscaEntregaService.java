package com.springapi.log.logapi.domain.service;

import com.springapi.log.logapi.domain.exception.NegocioException;
import com.springapi.log.logapi.domain.model.Entrega;
import com.springapi.log.logapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
    private EntregaRepository entregaRepository;
    public Entrega buscarEntregaService(Long entregaId){
        return entregaRepository.findById(entregaId)
        .orElseThrow(()-> new NegocioException("Entrega não encontrada"));

    }
    
}
