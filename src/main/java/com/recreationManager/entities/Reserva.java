package com.recreationManager.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "reserva")
public class Reserva  {

    @Id
    @GeneratedValue
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nro_documento")
    private Long nroDocumentoL;
    @Column(name = "inicio_fecha")
    private String inicioFecha;
    @Column(name = "fin_fecha")
    private String finFecha;
    @Column(name = "alojamiento")
    private String alojamiento;


}
