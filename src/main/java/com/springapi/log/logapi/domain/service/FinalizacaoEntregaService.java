package com.springapi.log.logapi.domain.service;

import javax.transaction.Transactional;

import com.springapi.log.logapi.domain.model.Entrega;
import com.springapi.log.logapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscarEntregaService(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
