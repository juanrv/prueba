package com.recreationManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReservaRequest {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("nroDocumento")
    private Long nroDocumentoL;
    @JsonProperty("inicioFecha")
    private String inicioFecha;
    @JsonProperty("finFecha")
    private String finFecha;
    @JsonProperty("alojamiento")
    private String alojamiento;
}
