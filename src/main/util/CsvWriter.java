package main.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import main.model.UserCustomSiyo;

public class CsvWriter {
	public void writeResultToCsv(String path, UserCustomSiyo userCustomSiyo) {
		try {
			PrintWriter printWriter = new PrintWriter(path);
			printWriter.println("kouji_number,spaceFinderId,shohin_code,juto_code,note");
			
			printWriter.print(userCustomSiyo.getKoujiNum() + ",");
			printWriter.print(userCustomSiyo.getSpaceFinderId() + ",");
			printWriter.print(userCustomSiyo.getShohinCode() + ",");
			for (String jutoCode : userCustomSiyo.getJutoCodes()) {
				printWriter.print(jutoCode + " ");
			}
			printWriter.print(",");
			printWriter.println(userCustomSiyo.getBikou());
			
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
