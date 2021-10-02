package com.fms.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fms.util.FMSUtil;

@Component
public class FMSFileWriter {
	
	public void writeContentToFile() {
		try {
			writeToFile(FMSUtil.FILENAME_ONE);
			writeToFile(FMSUtil.FILENAME_TWO);
	    } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void writeToFile(String filename) throws IOException {
		String fileLocation = new File(FMSUtil.BASE_LOCATION).getAbsolutePath() + "\\" + filename;
		BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(fileLocation,true));
		    String str = FMSUtil.getRandomStrLine(10).toString();
		    writer.write(str);
		} finally {
		    if (writer != null) writer.close();
		}
	}
}
