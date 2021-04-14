package com.recreationManager.validator;

import com.recreationManager.dto.ReservaRequest;
import com.recreationManager.util.exception.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ReservaValidatorImpl implements ReservaValidator {

    private static final String EL_NUMERO_DE_DOCUMENTO_NO_VALIDO = "El número  de documento no es valido.";
    private static final String EL_NOMBRE_PERSONA_ES_OBLIGATORIO = "El nombre es obligatorio.";
    private static final String EL_APELLIDO_PERSONA_ES_OBLIGATORIO = "El apellido es oblugatorio";
    private static final String LA_FECHA_ES_OBLIGATORIA = "La fecha es obligatoria";
    private static final String PATRON_FECHA = "dd/MM/yyyy";
    private static final String EXCEPCION_FORMATO_FECHA = "Formato de fecha incorrecto.";
    private static final String EXCEPCION_FECHA_MAYOR = "La fecha de reserva no puede ser inferior a la fecha actual.";
    private static final String EXCEPCION_FECHA_INICIO_MAYOR_FECHA_FIN = "La fecha de inicio no puede ser mayor a la fecha fin.";
    private static final String EL_ALOJAMIENTO_ES_OBLIGATORIO = "El alojamiento es obligatorio.";

    @Override
    public void validator(ReservaRequest reservaRequest) throws ApiUnprocessableEntity {
        validarNombre(reservaRequest.getNombre());
        validarApellido(reservaRequest.getApellido());
        validarNroDocumento(reservaRequest.getNroDocumentoL());
        validarInicioFecha(reservaRequest.getInicioFecha());
        validarFinFecha(reservaRequest.getFinFecha());
        validarRangoFechaReserva(reservaRequest.getInicioFecha(),reservaRequest.getFinFecha());
        validarAlojamiento(reservaRequest.getAlojamiento());
    }

    private void validarNombre(String nombre) throws ApiUnprocessableEntity {
        if (nombre.isEmpty() || nombre.equals("") || nombre.isBlank()) {
            message(EL_NOMBRE_PERSONA_ES_OBLIGATORIO);
        }
    }

    private void validarApellido(String apellido) throws ApiUnprocessableEntity {
        if (apellido.isEmpty() || apellido.equals("")) {
            message(EL_APELLIDO_PERSONA_ES_OBLIGATORIO);
        }
    }

    private void validarNroDocumento(Long nroDocumentoL) throws ApiUnprocessableEntity {
        if (nroDocumentoL <= 0 || nroDocumentoL >=2147000000 ) {
            message(EL_NUMERO_DE_DOCUMENTO_NO_VALIDO);
        }
    }

    private void validarInicioFecha(String inicioFecha) throws ApiUnprocessableEntity {
        if (inicioFecha.isEmpty() || inicioFecha.equals("")|| inicioFecha.isBlank()) {
            message(LA_FECHA_ES_OBLIGATORIA);
        }
        LocalDate localDateInicio = validarFormatoFecha(inicioFecha);
        validarFechaMayorAFechaActual(localDateInicio);
    }

    private void validarFinFecha(String FinFecha) throws ApiUnprocessableEntity {
        if (FinFecha.isEmpty() || FinFecha.equals("") || FinFecha.isBlank()) {
            message(LA_FECHA_ES_OBLIGATORIA);
        }
        LocalDate localDateFin = validarFormatoFecha(FinFecha);
        validarFechaMayorAFechaActual(localDateFin);
    }

    private LocalDate validarFormatoFecha(String fecha) throws ApiUnprocessableEntity {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATRON_FECHA);
            LocalDate localDate = LocalDate.parse(fecha, formatter);
            return localDate;
        } catch (Exception excepcion) {
            throw new ApiUnprocessableEntity(EXCEPCION_FORMATO_FECHA);
        }
    }

    public void validarFechaMayorAFechaActual(LocalDate fechaAValidar) throws ApiUnprocessableEntity {
        if (fechaAValidar.isBefore(LocalDate.now())) {
            throw new ApiUnprocessableEntity(EXCEPCION_FECHA_MAYOR);
        }
    }

    public void validarRangoFechaReserva(String fechaInicio, String fechaFin) throws ApiUnprocessableEntity {
        LocalDate localDateInicio = validarFormatoFecha(fechaInicio);
        LocalDate localDateFin = validarFormatoFecha(fechaFin);
        if (localDateInicio.isAfter(localDateFin)){
            throw new ApiUnprocessableEntity(EXCEPCION_FECHA_INICIO_MAYOR_FECHA_FIN);
        }
    }

    private void validarAlojamiento(String alojamiento) throws ApiUnprocessableEntity {
        if (alojamiento.isEmpty() || alojamiento.equals("") || alojamiento.isBlank()) {
            message(EL_ALOJAMIENTO_ES_OBLIGATORIO);
        }
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
