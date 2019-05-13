package com.bhatsac.microservices.currencyexchangeservice;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	/*@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "G:\\Mywrkspace\\eclipse_Wrk_space_spring_microservices\\currency-exchange-service\\src\\main\\resources\\certs\\client.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "client");
		System.setProperty("javax.net.ssl.trustStore", "G:\\Mywrkspace\\eclipse_Wrk_space_spring_microservices\\currency-exchange-service\\src\\main\\resources\\certs\\clientTrustStore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "client");
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName("client");
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}*/
}
