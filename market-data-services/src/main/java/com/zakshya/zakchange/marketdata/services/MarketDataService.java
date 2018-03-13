package com.zakshya.zakchange.marketdata.services;

import com.zakshya.zakchange.marketdata.domain.TickerInfo;
import com.zakshya.zakchange.marketdata.services.exceptions.CurrencyNotSupportedException;
import com.zakshya.zakchange.marketdata.services.mappers.TickerInfoMapper;
import com.zakshya.zakchange.marketdata.services.remoteservices.CryptoCompare;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MarketDataService {

    public final CryptoCompare cryptoCompare;
    public Set<String> supportedCoins;
    public Set<String> supportedCurrencies = new HashSet<>(Arrays.asList("EUR", "USD", "GBP"));

    public MarketDataService(CryptoCompare cryptoCompare) {
        this.cryptoCompare = cryptoCompare;
    }

    @PostConstruct
    public void init() {
        supportedCoins = cryptoCompare.getCoinList().getData().keySet();
    }

    public Map<String, TickerInfo> getLatestPrices(String from, String to, String exchange) {

        if (StringUtils.isEmpty(from))
            throw new IllegalArgumentException("from can not be empty");
        if (StringUtils.isEmpty(to))
            throw new IllegalArgumentException("to can not be null");

        HashSet<String> fromAsSet = new HashSet<>(Arrays.asList(from.split(",")));
        HashSet<String> toAsSet = new HashSet<>(Arrays.asList(to.split(",")));

        fromAsSet.removeAll(supportedCoins);
        fromAsSet.removeAll(supportedCurrencies);
        toAsSet.removeAll(supportedCoins);
        toAsSet.removeAll(supportedCurrencies);

        if (!CollectionUtils.isEmpty(fromAsSet))
            throw new CurrencyNotSupportedException("The following currencies are not supported [" + fromAsSet.stream().reduce("", (o, n) -> o.concat(n)).trim() + "]");
        if (!CollectionUtils.isEmpty(toAsSet)) {
            throw new CurrencyNotSupportedException("The following currencies are not supported [" + toAsSet.stream().reduce("", (o, n) -> o.concat(n)).trim() + "]");
        }

        return cryptoCompare.getLatestPrices(from, to, exchange)
                .getTickers()
                .values()
                .stream()
                .flatMap(tickers -> tickers.values().stream())
                .collect(Collectors.toMap(ticker -> ticker.getFromSymbol().concat("/").concat(ticker.getToSymbol()),
                        ticker -> TickerInfoMapper.from(ticker)));

    }
}
