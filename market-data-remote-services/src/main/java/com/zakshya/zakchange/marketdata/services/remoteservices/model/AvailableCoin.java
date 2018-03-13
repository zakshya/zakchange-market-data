package com.zakshya.zakchange.marketdata.services.remoteservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AvailableCoin {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("CoinName")
    private String coinName;
    @JsonProperty("FullName")
    private String fullName;
}
