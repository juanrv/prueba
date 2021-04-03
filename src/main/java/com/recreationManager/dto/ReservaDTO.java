package com.recreationManager.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class ReservaDTO {

    private Integer idReserva;
    private String nombre;
    private String apellido;
    private String inicioFecha;
    private String finFecha;
    private String alojamiento;
}
