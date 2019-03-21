package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
	
	
	private File log;
	
	
	public LogWriter(String path) {
		this.log = new File(path);
	}
	
	public void logFile(String message)  {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		message = dateTime + " " + message; 
		
		try (PrintWriter printLog = new PrintWriter(new FileOutputStream(log, true))) {
		printLog.println(message);
	}
		
		catch(IOException e) {
			e.getMessage();
			System.exit(1);
		}
	

}
}
