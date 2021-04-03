package com.recreationManager.services.interfaces;

import com.recreationManager.dto.ReservaDTO;

import com.recreationManager.dto.ReservaRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IReservaService {

    List<ReservaDTO> finAll();
    ReservaDTO findById(int idReserva);
    void save(ReservaRequest reservaRequest);

}
