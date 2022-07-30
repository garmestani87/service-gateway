package com.garm.servicegateway.exception;

import com.fasterxml.jackson.annotation.JsonValue;
import com.garm.infrastructure.base.enums.Convertible;

import java.util.Arrays;

public enum GatewayExceptionCode implements Convertible<String> {

    SUCCESSFUL("GT-EX-0000"),
    LOGIN_EXCEPTION("GT-EX-0001"),
    ACCOUNT_DETAIL_EXCEPTION("GT-EX-0002"),
    SETAN_FINANCIAL_INSTITUTE_EXCEPTION("GT-EX-0003"),
    SETAN_BROKER_EXCEPTION("GT-EX-0004"),;

    private final String value;

    GatewayExceptionCode(String value) {
        this.value = value;
    }

    public GatewayExceptionCode findByValue(String value) {
        return Arrays.stream(values()).filter(exceptionCode -> exceptionCode.value.equals(value)).findFcomst().orElse(null);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.value;
    }
}
