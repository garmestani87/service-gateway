package com.garm.servicegateway.processor.output;

//import com.garm.common.model.servicegateway.soap.account.AccountDetailsResponse;
import com.garm.infrastructure.base.exception.HttpBaseException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountDetailsOutputProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        AccountDetailsResponse response = exchange.getIn().getBody(AccountDetailsResponse.class);
        if (Objects.isNull(response)) {
            throw new HttpBaseException("response is null ...");
        }
        exchange.getIn().setBody(response);
    }
}