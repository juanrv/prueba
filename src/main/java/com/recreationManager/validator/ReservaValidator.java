package com.recreationManager.validator;

import com.recreationManager.dto.ReservaRequest;
import com.recreationManager.util.exception.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

@Service
public interface ReservaValidator {

    void validator(ReservaRequest reservaRequest) throws ApiUnprocessableEntity;
}
