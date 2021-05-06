package com.myproject.servicerest;

import com.sun.net.httpserver.HttpServer;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run(args);
    }

}

