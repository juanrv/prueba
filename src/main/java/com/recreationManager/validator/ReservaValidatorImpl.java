package com.recreationManager.validator;

import com.recreationManager.dto.ReservaRequest;
import com.recreationManager.util.exception.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservaValidatorImpl implements ReservaValidator {

    @Override
    public void validator(ReservaRequest reservaRequest) throws ApiUnprocessableEntity {
        message("Ensayo mensaje validador");
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
