package com.springapi.log.logapi.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.springapi.log.logapi.api.modelrepresentation.EntregaRepresentation;
import com.springapi.log.logapi.api.modelrepresentation.input.EntregaInput;
import com.springapi.log.logapi.domain.model.Entrega;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {
    private ModelMapper modelMapper;
    public EntregaRepresentation toReprentation(Entrega entrega)   {
        
        return modelMapper.map(entrega, EntregaRepresentation.class);
    }

    public List<EntregaRepresentation> toClollectionReprentation(List<Entrega> entregas) {
        return entregas.stream()
        .map(this::toReprentation)
        .collect(Collectors.toList());
    }
    public Entrega toEntity(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
