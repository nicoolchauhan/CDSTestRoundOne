package com.fms.util;

import java.util.Random;
import java.util.UUID;

public class FMSUtil {
	public final static String KEYWORD = "CDS";
	public final static int WAITAGE = 50;
	public final static String FILENAME_ONE = "fileone.txt";
	public final static String FILENAME_TWO = "filetwo.txt";
	public final static String FILENAME_LOGFILE = "search_results.log";
	public final static String BASE_LOCATION = "src\\main\\resources";

	private static String generateRandomString() {
		String randomStr = null;
		for(int i=0;i<20;i++) {
			if(rand50() > WAITAGE) 
				randomStr = usingUUID();
			else {
				randomStr = KEYWORD;
			}
		}
		return randomStr;
	}
	
	private static String usingUUID() { 
	    UUID randomUUID = UUID.randomUUID(); 
	    return randomUUID.toString().replaceAll("-", ""); 
	} 
	
	private static int rand50()
    {
        Random r = new Random();
        return r.nextInt(100);
    }
	
	public static StringBuilder getRandomStrLine(int lineLength) {
		StringBuilder line = new StringBuilder();
		for(int i=0;i<lineLength;i++) {
			line.append(generateRandomString()).append(" ");
		}
		return line;
	}
}
