package com.garm.servicegateway.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GatewayExceptionModel {
    private String message;
    private Object stackTrace;
    private String code;
    private GatewayExceptionCode exceptionCode;
}
