package com.zakshya.zakchange.marketdata.services.remoteservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class MultiPriceResponse {

    @JsonProperty("RAW")
    private  HashMap<String, HashMap<String, CryptoCompareTicker>> tickers;
}
