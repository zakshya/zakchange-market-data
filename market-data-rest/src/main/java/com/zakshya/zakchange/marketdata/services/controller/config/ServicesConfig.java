package com.zakshya.zakchange.marketdata.services.controller.config;

import com.zakshya.zakchange.marketdata.services.MarketDataService;
import com.zakshya.zakchange.marketdata.services.remoteservices.CryptoCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    @Autowired
    public MarketDataService marketDataService(CryptoCompare cryptoCompare) {
        return new MarketDataService(cryptoCompare);
    }
}
