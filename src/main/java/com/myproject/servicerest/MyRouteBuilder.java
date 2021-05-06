package com.myproject.servicerest;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.xml.sax.SAXException;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        restConfiguration()
            .component("jetty")
            .host("localhost")
            .scheme("http")
            .port("9091")
            .bindingMode(RestBindingMode.auto);

        rest()
            .get()
            .route()
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(403))
                .bean(ResponseBean.class,"stat");
    }
}
