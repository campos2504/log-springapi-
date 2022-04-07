package com.springapi.log.logapi.api.mapper;

import java.util.List;

import com.springapi.log.logapi.api.modelrepresentation.OcorrenciaRepresentation;
import com.springapi.log.logapi.domain.model.Ocorrencia;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaRepresentation toRepresentation(Ocorrencia ocorrencia) {

        return modelMapper.map(ocorrencia, OcorrenciaRepresentation.class);

    }

    public List<OcorrenciaRepresentation> toClollectionReprentation(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toRepresentation)
                .toList();

    }

}
