package com.project.nbp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NbpApplication {
    
    private static final Logger log = LoggerFactory.getLogger(NbpApplication.class);

	public static void main(String[] args) {
            SpringApplication.run(NbpApplication.class, args);
	}
        
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder){
            return builder.build();
        }
        
        @Bean
        public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
            String day = "2021-03-03";  //RRRR-MM-DD
            String url = "http://api.nbp.pl/api/exchangerates/tables/C/"+day+"?format=json";
            
            return args -> {
                try{
                    //ExchangeRates[] - json string is an array element
                    ExchangeRates[] exchangeTable = restTemplate.getForObject(url, new ExchangeRates[] {}.getClass());
                    log.info("\n\nKursy na dzień: "+day+exchangeTable[0].toString());
                }
                catch(HttpClientErrorException e){
                    log.info("\n\nWystąpił problem z kursami na "+day+": "+e.getMessage());
                }
            };
        }

}