package com.intact.eCMCCMPSMeeting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

public class CSV {
	private ArrayList<Record> records = new ArrayList<Record>();
	
	public ArrayList<Record> getRecords(String fileName) {
		File csvFile = new File(fileName);
		String readFileToString;
		CSVParser parser = null;
		
		try {
			readFileToString = FileUtils.readFileToString(csvFile);
			parser = CSVParser.parse(readFileToString, CSVFormat.DEFAULT);
		} catch (IOException e) {
			System.out.println("Error getting CSV Parser.");
			e.printStackTrace();
		}
		
		int rowNum = 0;
		
		for (CSVRecord csvRecord : parser) {
			int colNum = 0;
			
			int incidentIdCol = 0;
			int titleCol = 0;
			int assigneeCol = 0;
			int assignmentGroupCol = 0;
			int openTimeCol = 0;
			int solutionCol = 0;
			int updateActionCol = 0;
			
			if (rowNum == 0) {
				
				while (colNum < csvRecord.size()) {
					String header = csvRecord.get(colNum);
					
					if (header.equals("Incident ID")) {
						incidentIdCol = colNum;
					} else if (header.equals("Title")) {
						titleCol = colNum;
					} else if (header.equals("Assignee")) {
						assigneeCol = colNum;
					} else if (header.equals("Assignment Group")) {
						assignmentGroupCol = colNum;
					} else if (header.equals("Open Time")) {
						openTimeCol = colNum;
					} else if (header.equals("Solution")) {
						solutionCol = colNum;
					} else if (header.equals("Update Action")) {
						updateActionCol = colNum;
					}
					colNum++;
				}
			} else {
				String value = csvRecord.get(colNum);
				
				if (colNum == incidentIdCol) {
					
				} else if (colNum == titleCol) {
					
				} else if (colNum == assigneeCol) {
					
				} else if (colNum == assignmentGroupCol) {
					
				} else if (colNum == openTimeCol) {
					
				} else if (colNum == solutionCol) {
					
				} else if (colNum == updateActionCol) {
					
				}
			}
			rowNum++;
			
		}
		
		return records;
	}

}
