package com.github.thecoolersuptelov.currencyconvertionservice.controller;

import com.github.thecoolersuptelov.currencyconvertionservice.domain.CurrencyConversion;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RestController
public class CurrencyConversionController {

    private final Environment environment;

    public CurrencyConversionController(Environment environment) {
        this.environment = environment;
    }
    @GetMapping(value = "from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable @NonNull String fromCurrency, @PathVariable @NonNull String toCurrency, @PathVariable @NonNull Long quantity) {

        var uriVariables = new HashMap<String, String>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);
        var xx = new RestTemplate().
                getForEntity(
                        "http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}"
                        ,CurrencyConversion.class
                        , uriVariables
                ).getBody();
        xx.setTotalCalculatedAmount(quantity*xx.getConvertionMultiple());
        xx.setQuantity(quantity);

        return xx.setEnviroment(environment.getProperty("local.server.port"));
    //    return new CurrencyConversion(fromCurrency,toCurrency,quantity, 0l, 0l).setEnviroment(environment.getProperty("local.server.port"));
    }

}
