package com.zakshya.zakchange.marketdata.services.remoteservices;


import com.zakshya.zakchange.marketdata.services.remoteservices.model.AvailableCoinList;
import com.zakshya.zakchange.marketdata.services.remoteservices.model.CryptoCompareResponse;
import com.zakshya.zakchange.marketdata.services.remoteservices.model.MultiPriceResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="cryptoCompare", url = "${cryptocompare.price.url}")
public interface CryptoCompare {

    @RequestMapping(path = "/data/pricemultifull", method = RequestMethod.GET)
    public MultiPriceResponse getLatestPrices(
            @RequestParam("fsyms") String from,
            @RequestParam("tsyms") String to,
            @RequestParam(value = "e", required = false) String exchangeName);

    @RequestMapping(path = "/data/all/coinlist", method = RequestMethod.GET)
    public CryptoCompareResponse<AvailableCoinList> getCoinList();

}
