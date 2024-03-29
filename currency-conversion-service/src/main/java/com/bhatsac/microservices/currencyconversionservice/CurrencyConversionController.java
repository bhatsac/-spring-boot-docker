package com.bhatsac.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyRest
	(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		///TODO: Just like we use  repository to talk to JPa, we need Proxy to talk to External microservices.
		
		logger.info("This is a request for currency conversion from {} to {} for quantity {}",from,to,quantity);
		
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://currency-exchange-service:8000/currenct-exchange/from/{from}/to/{to}", 
										 CurrencyConversionBean.class,
										 uriVariables);
		
		CurrencyConversionBean currencyConversionBean = responseEntity.getBody();
		return new CurrencyConversionBean(currencyConversionBean.getId(),
											from, 
											to,
											currencyConversionBean.getConversionMultiple(),
											quantity,
											quantity.multiply(currencyConversionBean.getConversionMultiple()),
											8100);
		
		
	}
	
	// TODO : This one is using feign
	@GetMapping("/currency-converter/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign
	(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		///TODO: Just like we use  repository to talk to JPA, we need Proxy to talk to External microservices.
		CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.convertCurrency(from, to);
		logger.info(String.valueOf(currencyConversionBean.getPort()));
		logger.info("This is a request for currency conversion from {} to {} ",from,to);
		 CurrencyConversionBean currencyConversionBean2 = new CurrencyConversionBean(currencyConversionBean.getId(),
											from, 
											to,
											currencyConversionBean.getConversionMultiple(),
											quantity,
											quantity.multiply(currencyConversionBean.getConversionMultiple()),
											currencyConversionBean.getPort());
		logger.info("This is the {}",currencyConversionBean2);
		logger.info("<><>><><><><><><><><>><><><><><><><><>><><><><><><>");
		logger.info("<><>><><><><><><><><>><><><><><><><><>><><><><><><>");
		logger.info("<><>><><><><><><><><>><><><><><><><><>><><><><><><>");
		logger.info("<><>><><><><><><><><>><><><><><><><><>><><><><><><>");
		 return currencyConversionBean2;
	}
}
