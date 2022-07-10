package com.github.thecoolersuptelov.currencyconvertionservice.controller;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversion {

    @GetMapping(value = "from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable @NonNull String fromCurrency, @PathVariable @NonNull String toCurrency, @PathVariable @NonNull Integer quantity) {
        return new CurrencyConversion();
    }

}
