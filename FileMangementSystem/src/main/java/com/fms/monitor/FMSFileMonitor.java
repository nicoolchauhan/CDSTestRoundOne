package com.fms.monitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fms.util.FMSUtil;

@Component
public class FMSFileMonitor {
	
	public void ReadContentToFile() {
		try {
			readFile(FMSUtil.FILENAME_ONE);
			readFile(FMSUtil.FILENAME_TWO);
	    } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void readFile(String filename) throws IOException {
		String result = null;
		String fileLocation = new File(FMSUtil.BASE_LOCATION).getAbsolutePath() + "\\" + filename;
		BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		String st;
		try {
		  while ((st = br.readLine()) != null) {
			  String[] readLineSplit = st.split(" ");
			  List<String> wordList = Arrays.asList(readLineSplit);  
			  long count = wordList.stream().filter(e -> e.equals(FMSUtil.KEYWORD)).count();
			  //long countNot = wordList.stream().filter(e -> !e.equals(FMSUtil.KEYWORD)).count();
			  result = filename + " - " + count + "\n";
		  }
		}finally {
		    if (br != null) br.close();
		}
		logSearchResult(result);
	}
	
	public void logSearchResult(String searchResult) throws IOException {
		String fileLocation = new File(FMSUtil.BASE_LOCATION).getAbsolutePath() + "\\" + FMSUtil.FILENAME_LOGFILE;
		
		BufferedWriter writer = null;
		try {		   
			writer = new BufferedWriter(new FileWriter(fileLocation,true));
			writer.write(searchResult);
		}finally {
		    if (writer != null) writer.close();
		}
	}
}
