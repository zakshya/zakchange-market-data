package com.zakshya.zakchange.marketdata.services.remoteservices.config;

import com.zakshya.zakchange.marketdata.services.remoteservices.CryptoCompare;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackageClasses = {CryptoCompare.class})
@Configuration
public class RemoteConfig {
}