package com.bhatsac.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//TODO : spring.application.name=currency-exchange-service, from app properties name is set
//@FeignClient(name="currency-exchange-service", url="localhost:8001")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	
	//@GetMapping("/currenct-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currenct-exchange/from/{from}/to/{to}")  //this is after we set up api gateway
	public CurrencyConversionBean convertCurrency
	(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
