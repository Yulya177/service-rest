/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.servicerest;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author nasretdinova.u.k
 */
public class ResponseBean {
        public String stat() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
            FileParcer parcer = new FileParcer();
           
            String bodyResponse;

            parcer.init();
            
            bodyResponse = "Name: " + parcer.getListValue("project/artifactId") +
                           "\n"                                                +
                           "Version: " + parcer.getListValue("project/version");

            return bodyResponse;
        }
    
}
