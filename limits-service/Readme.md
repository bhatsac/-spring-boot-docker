#--How to generate a key store.

keytool -genkey -alias client -keystore client.jks -keyalg RSA -keysize 2048 -validity 365 -ext SAN=dns:localhost,ip:127.0.0.1
keytool -genkey -alias clientTrustStore -keystore clientTrustStore.jks -keyalg RSA -keysize 2048 -validity 365 -ext SAN=dns:localhost,ip:127.0.0.1
keytool -genkey -alias eureka -keystore eureka.jks -keyalg RSA -keysize 2048 -validity 365 -ext SAN=dns:localhost,ip:127.0.0.1
keytool -genkey -alias eurekaTrustStore -keystore eurekaTrustStore.jks -keyalg RSA -keysize 2048 -validity 365 -ext SAN=dns:localhost,ip:127.0.0.1

keytool -export -alias client -file client.cer -keystore client.jks
keytool -export -alias eureka -file eureka.cer -keystore eureka.jks

keytool -import -alias eureka -file eureka.cer -keystore clientTrustStore.jks -storepass client
keytool -import -alias client -file client.cer -keystore eurekaTrustStore.jks -storepass eureka