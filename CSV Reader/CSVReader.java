package com.esi.vdss.th.core;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader{
	
	private static final String  CSV_FILE_PATH = "E:/Documents/Result.csv";
	
	public static void main(String[] args) throws IOException{
		try(
				Reader reader =Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
				
				CSVParser parser =new CSVParser(reader,CSVFormat.DEFAULT
						.withFirstRecordAsHeader()
						.withIgnoreHeaderCase()
						.withTrim() 
						
						);//instead of csv parser you can also use iterable function to parse it.something like this 
						//Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
				
				)
		{
			for(CSVRecord record: parser){
				//now we can access value by csvRecord by passing record name
				
				String name = record.get("ProductName");
				String status =record.get("Status");
				String stdout =record.get("Stdout");
				String stderr = record.get("Stderr");
				
				System.out.println("Record No - " + record.getRecordNumber());
                System.out.println("Name : " + name);
                System.out.println("status : " + status);
                System.out.println("Stdout : " + stdout);
                System.out.println("Stderr : " + stderr);
				
			}
			
			
		}
		
		
		
	}
	
	
	
}