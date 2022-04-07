package com.springapi.log.logapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.springapi.log.logapi.api.mapper.EntregaMapper;
import com.springapi.log.logapi.api.modelrepresentation.EntregaRepresentation;
import com.springapi.log.logapi.api.modelrepresentation.input.EntregaInput;
import com.springapi.log.logapi.domain.repository.EntregaRepository;
import com.springapi.log.logapi.domain.service.FinalizacaoEntregaService;
import com.springapi.log.logapi.domain.service.SolicitacaoEntregaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaRepresentation solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        return entregaMapper.toReprentation(solicitacaoEntregaService
        .solicitar(entregaMapper.toEntity(entregaInput)));
        
    }

    @GetMapping
    public List<EntregaRepresentation> listar() {
        return entregaMapper.toClollectionReprentation(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaRepresentation> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
        .map(entrega-> ResponseEntity.ok(entregaMapper.toReprentation(entrega)))
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
        
    }
    
}
