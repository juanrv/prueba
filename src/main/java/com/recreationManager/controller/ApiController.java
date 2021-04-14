package com.recreationManager.controller;


import com.recreationManager.dto.ReservaDTO;
import com.recreationManager.dto.ReservaRequest;
import com.recreationManager.services.interfaces.IReservaService;
import com.recreationManager.util.exception.ApiUnprocessableEntity;
import com.recreationManager.validator.ReservaValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/reserva")
public class ApiController {

    @Autowired
    private IReservaService reservaService;

    @Autowired
    private ReservaValidatorImpl reservaValidator;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.reservaService.finAll());
    }

    @GetMapping(value = "/by/{idReserva}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable ("idReserva") int idReserva ){
        return ResponseEntity.ok(this.reservaService.findById(idReserva));
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody ReservaRequest reservaRequest) throws ApiUnprocessableEntity {
        this.reservaValidator.validator(reservaRequest);
        this.reservaService.save(reservaRequest);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
