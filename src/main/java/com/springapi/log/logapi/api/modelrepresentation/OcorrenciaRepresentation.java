package com.springapi.log.logapi.api.modelrepresentation;

import java.time.OffsetDateTime;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaRepresentation {
    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
