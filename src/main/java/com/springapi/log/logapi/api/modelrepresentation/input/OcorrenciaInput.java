package com.springapi.log.logapi.api.modelrepresentation.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInput {
    
    @NotBlank
    private String descricao;
}
