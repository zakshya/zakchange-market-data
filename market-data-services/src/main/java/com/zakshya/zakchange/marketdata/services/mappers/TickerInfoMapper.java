package com.zakshya.zakchange.marketdata.services.mappers;

import com.zakshya.zakchange.marketdata.domain.TickerInfo;
import com.zakshya.zakchange.marketdata.services.remoteservices.model.CryptoCompareTicker;

public class TickerInfoMapper {

    private TickerInfoMapper() {
    }

    public static TickerInfo from(CryptoCompareTicker cryptoCompareTicker) {
        return TickerInfo.builder()
                .base(cryptoCompareTicker.getFromSymbol())
                .counter(cryptoCompareTicker.getToSymbol())
                .price(cryptoCompareTicker.getPrice())
                .change24Hour(cryptoCompareTicker.getChange24Hour())
                .changePct24hour(cryptoCompareTicker.getChangePct24hour())
                .openDay(cryptoCompareTicker.getOpenDay())
                .highDay(cryptoCompareTicker.getHighDay())
                .lowDay(cryptoCompareTicker.getLowDay())
                .open24Hour(cryptoCompareTicker.getOpen24Hour())
                .high24Hour(cryptoCompareTicker.getHigh24Hour())
                .low24Hour(cryptoCompareTicker.getLow24Hour())
                .build();
    }
}
