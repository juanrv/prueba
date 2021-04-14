package com.recreationManager.services.implementation;

import com.recreationManager.dto.ReservaDTO;
import com.recreationManager.dto.ReservaRequest;
import com.recreationManager.entities.Reserva;
import com.recreationManager.repository.ReservaRepository;
import com.recreationManager.services.interfaces.IReservaService;
import com.recreationManager.util.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReservasImpl  implements IReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<ReservaDTO> finAll() {
        List<ReservaDTO> listaDTO=new ArrayList<>();

        Iterable<Reserva> reservas=this.reservaRepository.findAll();

        for (Reserva reserva : reservas ) {
            ReservaDTO reservaDTO=MHelpers.modelMapper().map(reserva,  ReservaDTO.class);
            listaDTO.add(reservaDTO);
        }
        
        return listaDTO;
    }

    @Override
    public ReservaDTO findById(int idReserva) {
        Optional<Reserva> reserva= this.reservaRepository.findById(idReserva);

        if(!reserva.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map(reserva.get(), ReservaDTO.class);
    }

    @Override
    public void save(ReservaRequest reservaRequest) {
        Reserva reserva= MHelpers.modelMapper().map(reservaRequest,Reserva.class);
        this.reservaRepository.save(reserva);
}


}
