package com.garm.servicegateway.processor.input;

import com.google.gson.Gson;
//import com.garm.common.model.servicegateway.soap.account.AccountDetailsRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsInputProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        AccountDetailsRequest request = new Gson().fromJson(exchange.getIn().getBody(String.class), AccountDetailsRequest.class);
        exchange.getIn().setBody(request);

    }
}