package main.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import main.model.UserCustomSiyo;

public class XmlReader {
	public UserCustomSiyo readXml(String path) {
		UserCustomSiyo userCustomSiyo = null;
		
		try {
			File inputFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("user");
            
            for (int i = 0; i < nList.getLength(); i++) {
            	String koujiNumber = doc.getElementsByTagName("kouji_number").item(i).getTextContent();
                String spaceFinderId = doc.getElementsByTagName("spaceFinderId").item(i).getTextContent();
                String shohinCode = doc.getElementsByTagName("shohin_code").item(i).getTextContent();
                String bikou = doc.getElementsByTagName("bikou").item(i).getNodeValue();
                List<String> jutoCodes = new ArrayList<String>();
                NodeList jutoCodeList = doc.getElementsByTagName("juto_code");
                for (int j = 0; j < jutoCodeList.getLength(); j++) {
                    jutoCodes.add(jutoCodeList.item(j).getTextContent());
                }
                
                userCustomSiyo = new UserCustomSiyo(koujiNumber, spaceFinderId, shohinCode, jutoCodes, bikou);
            }
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		return userCustomSiyo;
	}
}
