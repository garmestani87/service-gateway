package com.garm.servicegateway.exception;

import com.garm.infrastructure.base.exception.BaseException;
import com.garm.infrastructure.base.exception.HttpBaseException;
import com.garm.infrastructure.base.model.service.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ServiceGatewayExceptionHandler extends ResponseEntityExceptionHandler {


    public static ResponseEntity<Object> handleException(BaseException ex, GatewayExceptionCode code) {
        Response<Object, Object> response = new Response<>();
        HttpBaseException exception = new HttpBaseException(ex.getMessage());
        exception.setHttpMessage(ex.getMessage());
        response.setResponse(GatewayExceptionModel.builder()
                .message(ex.getMessage())
                .stackTrace(ex.getStackTrace())
                .exceptionCode(code)
                .build());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
