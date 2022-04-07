package com.springapi.log.logapi.domain.service;


import javax.transaction.Transactional;


import com.springapi.log.logapi.domain.model.Entrega;
import com.springapi.log.logapi.domain.model.Ocorrencia;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
    BuscaEntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = entregaService.buscarEntregaService(entregaId);
        
        return entrega.adicionarOcorrencia(descricao);

    }
}
