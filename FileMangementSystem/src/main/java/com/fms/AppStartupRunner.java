package com.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fms.monitor.FMSFileMonitor;
import com.fms.writer.FMSFileWriter;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired 
	FMSFileWriter pmsFileWriter;
	
	@Autowired 
	FMSFileMonitor fmsFileMonitor;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		pmsFileWriter.writeContentToFile();
		fmsFileMonitor.ReadContentToFile();
	}
   
}