package tw.gov.cwb; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
  

@SpringBootApplication
@EnableScheduling
public class WeatherToBeanApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WeatherToBeanApplication.class);
 
	public static void main(String[] args) {
		SpringApplication.run(WeatherToBeanApplication.class, args);
	}
	
	 
	 

}
