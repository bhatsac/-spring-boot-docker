package com.bhatsac.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currenct-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchnageValue(@PathVariable String from , @PathVariable String to){
		// ExchangeValue exchangeValue = new ExchangeValue(100L, from, to, BigDecimal.valueOf(65));
		System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
		 ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		 exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
	
		 
		 return exchangeValue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/isup")
	public String isUP(){
		// ExchangeValue exchangeValue = new ExchangeValue(100L, from, to, BigDecimal.valueOf(65));
		
		 return "I am up and Rocking!!";
	}

}
