package com.springapi.log.logapi.api.modelrepresentation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.springapi.log.logapi.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaRepresentation {

    private Long id;
    private ClienteResumeRepresentation cliente;
    private DestinatarioRepresentation destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

    
}
