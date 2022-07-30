package com.garm.servicegateway.util;

import com.garm.infrastructure.base.exception.ExceptionModel;

public interface ProcessorExceptionHandler {
    default ExceptionModel handleError(Throwable throwable) {
        return new ExceptionModel().setMessage(throwable.getMessage());
    }
}
