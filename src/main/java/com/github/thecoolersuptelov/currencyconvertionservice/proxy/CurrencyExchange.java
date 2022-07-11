package com.github.thecoolersuptelov.currencyconvertionservice.proxy;

import com.github.thecoolersuptelov.currencyconvertionservice.domain.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchange {

    @GetMapping(value = "from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion retriveExchangeValue(@PathVariable @NonNull String fromCurrency, @PathVariable @NonNull String toCurrency);

}
