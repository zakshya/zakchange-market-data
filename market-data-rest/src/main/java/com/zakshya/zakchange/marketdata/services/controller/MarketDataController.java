package com.zakshya.zakchange.marketdata.services.controller;

import com.zakshya.zakchange.marketdata.domain.TickerInfo;
import com.zakshya.zakchange.marketdata.services.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/market-data")
public class MarketDataController {

    private final MarketDataService marketDataService;

    @Autowired
    public MarketDataController(MarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    @RequestMapping(value = "/ticker", method = RequestMethod.GET)
    public ResponseEntity<Map<String, TickerInfo>> getTicker(@RequestParam("from") String from,
                                                             @RequestParam("to") String to,
                                                             @RequestParam(value = "exchange", required = false) String exchange) {
        return ResponseEntity.ok(this.marketDataService.getLatestPrices(from, to, exchange));

    }
}
