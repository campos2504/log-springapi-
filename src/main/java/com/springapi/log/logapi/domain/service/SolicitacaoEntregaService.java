package com.springapi.log.logapi.domain.service;


import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import com.springapi.log.logapi.domain.model.Cliente;
import com.springapi.log.logapi.domain.model.Entrega;
import com.springapi.log.logapi.domain.model.StatusEntrega;
import com.springapi.log.logapi.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
    
    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente=catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);

    }


}
