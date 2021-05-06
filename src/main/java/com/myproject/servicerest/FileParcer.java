/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.servicerest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author nasretdinova.u.k
 */
public class FileParcer {
    public XPath xPath;
    public Document xmlDocument;
    
    public void init() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =  builderFactory.newDocumentBuilder();
        
        String pathToFile = Paths.get(".").toAbsolutePath().normalize().toString();
        
        File file = new File(pathToFile,"pom.xml");

        this.xmlDocument = builder.parse(file);

        this.xmlDocument.getDocumentElement().normalize();
        
        this.xPath = XPathFactory.newInstance().newXPath();
    }
    
    public String getListValue(String nameNode) throws XPathExpressionException {
        String nodeValueList = "";
        NodeList nodeList;
        
        nodeList = (NodeList) this.xPath.compile(nameNode).evaluate(this.xmlDocument, XPathConstants.NODESET);
                
        for(int i = 0 ; i < nodeList.getLength() ; i++) {
            if (!"".equals(nodeValueList))
                nodeValueList = nodeValueList + ",";

            nodeValueList = nodeValueList + nodeList.item(i).getTextContent();
        }
        return nodeValueList;
    }
}
