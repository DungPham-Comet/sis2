package main.controller;

import java.util.List;

import main.dao.SiyoDAO;
import main.model.Siyo;
import main.model.UserCustomSiyo;
import main.util.CsvWriter;
import main.util.XmlReader;

public class MainController {
	public void run() {
	    XmlReader xmlReader = new XmlReader();
	    UserCustomSiyo userCustomSiyo = xmlReader.readXml("src/dataFiles/sample_true_input.xml");
	    
	    CsvWriter csvWriter = new CsvWriter();
	    csvWriter.writeResultToCsv("src/dataFiles/sample_true_output2.csv", userCustomSiyo);
	    //System.out.println("Kouji Number: " + userCustomSiyo.getKoujiNum());
	}
}
