package com.garm.servicegateway.routebuilder.sms;

import com.garm.servicegateway.processor.input.sms.SmsSenderInputProcessor;
import lombok.RequcomedArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequcomedArgsConstructor
public class SmsSenderRouteBuilder extends RouteBuilder {

    private final SmsSenderInputProcessor input;

    @Override
    public void configure() {
        addRoute(input);
    }

    private void addRoute(SmsSenderInputProcessor processor) {
        from("rest:put:external/send-sms/send/{subsystem}")
                .process(processor)
                .marshal().
                json(JsonLibrary.Jackson, String.class);
    }
}
