package com.bhatsac.microservices.currencyexchangeservice;

/*@Configuration
public class SslConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(LoggerConfiguration.class);

    
    private File trustStore= new File("G:\\Mywrkspace\\eclipse_Wrk_space_spring_microservices\\currency-exchange-service\\src\\main\\resources\\certs\\clientTrustStore.jks");
    @Value("${server.ssl.trust-store-password}")
    private String trustStorePassword;


    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs getTrustStoredEurekaClient(SSLContext sslContext) {
    	System.out.println("******************************************************************");
    	System.out.println("******************************************************************");
    	System.out.println(trustStore);
    	System.out.println(trustStorePassword);
    	System.out.println("******************************************************************");
    	System.out.println("******************************************************************");
        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        args.setSSLContext(sslContext);
        return args;
    }

    @Bean
    public SSLContext sslContext() throws Exception {
        logger.info("initialize ssl context bean with keystore {} ", trustStore);
        return new SSLContextBuilder()
                .loadTrustMaterial(
                        trustStore,
                        trustStorePassword.toCharArray()
                ).build();
    }
}*/