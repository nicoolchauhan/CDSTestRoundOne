package com.fms;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.fms.monitor.FMSFileMonitor;
import com.fms.writer.FMSFileWriter;

@SpringBootApplication
@EnableScheduling
public class FileMangementSystemApplication {
	
	@Autowired
	FMSFileWriter pmsFileWriter;
	
	@Autowired 
	FMSFileMonitor fmsFileMonitor;
	
	public static void main(String[] args) {
		SpringApplication.run(FileMangementSystemApplication.class, args);
	}
	
	@Scheduled(fixedDelay = 1000*10)
	public void scheduleFixedDelayTaskWriter() {
		System.out.println("scheduleFixedDelayTaskWriter " + new Date());
		pmsFileWriter.writeContentToFile();
	}
	
	@Scheduled(fixedDelay = 1000*30)
	public void scheduleFixedDelayTaskReader() {
		System.out.println("scheduleFixedDelayTaskReader " + new Date());
		fmsFileMonitor.ReadContentToFile();
	}
}
