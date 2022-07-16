package com.github.thecoolersuptelov.currencyconvertionservice.controller;

import com.github.thecoolersuptelov.currencyconvertionservice.domain.CurrencyConversion;
import com.github.thecoolersuptelov.currencyconvertionservice.proxy.CurrencyExchange;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RestController
@RequestMapping(value = "/currency-conversion-service/")
public class CurrencyConversionController {

    private final Environment environment;
    private final CurrencyExchange curExchangeProxy;

    public CurrencyConversionController(Environment environment, CurrencyExchange exchange) {
        this.environment = environment;
        this.curExchangeProxy = exchange;
    }

    @GetMapping(value = "from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable @NonNull String fromCurrency, @PathVariable @NonNull String toCurrency, @PathVariable @NonNull Long quantity) {

        var uriVariables = new HashMap<String, String>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);
        var xx = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}", CurrencyConversion.class, uriVariables).getBody();
        xx.setTotalCalculatedAmount(quantity * xx.getConvertionMultiple());
        xx.setQuantity(quantity);

        return xx.setEnviroment(environment.getProperty("local.server.port"));
        //    return new CurrencyConversion(fromCurrency,toCurrency,quantity, 0l, 0l).setEnviroment(environment.getProperty("local.server.port"));
    }

    @GetMapping(value = "/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionThroughOpenFeign(@PathVariable @NonNull String fromCurrency, @PathVariable @NonNull String toCurrency, @PathVariable @NonNull Long quantity) {

        var currencyConversionFromProxy = curExchangeProxy.retriveExchangeValue(fromCurrency, toCurrency);
        currencyConversionFromProxy.setTotalCalculatedAmount(quantity * currencyConversionFromProxy.getConvertionMultiple());
        currencyConversionFromProxy.setQuantity(quantity);

        return currencyConversionFromProxy.setEnviroment(environment.getProperty("local.server.port"));
    }
}
