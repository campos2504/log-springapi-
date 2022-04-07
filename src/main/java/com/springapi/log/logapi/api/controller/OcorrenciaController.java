package com.springapi.log.logapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.springapi.log.logapi.api.mapper.OcorrenciaMapper;

import com.springapi.log.logapi.api.modelrepresentation.OcorrenciaRepresentation;
import com.springapi.log.logapi.api.modelrepresentation.input.OcorrenciaInput;
import com.springapi.log.logapi.domain.model.Entrega;
import com.springapi.log.logapi.domain.service.BuscaEntregaService;
import com.springapi.log.logapi.domain.service.RegistroOcorrenciaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@AllArgsConstructor
public class OcorrenciaController {
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaRepresentation registrar(@PathVariable Long entregaId,
            @RequestBody @Valid OcorrenciaInput ocorrenciaInput) {
        return ocorrenciaMapper
                .toRepresentation(registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao()));
    }



    @GetMapping
    public List<OcorrenciaRepresentation> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscarEntregaService(entregaId);       
        return ocorrenciaMapper.toClollectionReprentation(entrega.getOcorrencias());
        
    }

}
