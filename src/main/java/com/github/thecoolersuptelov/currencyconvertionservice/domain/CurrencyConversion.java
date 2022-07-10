package com.github.thecoolersuptelov.currencyconvertionservice.domain;

import java.util.UUID;

public class CurrencyConversion {
    private UUID id;
    private String fromCurrency;
    private String toCurrency;
    private Long convertionMultiple;
    private Long totalCalculatedAmount;
    private Long quantity;
    private String enviroment;

    public CurrencyConversion(String fromCurrency, String toCurrency, Long convertionMultiple, Long totalCalculatedAmount, Long quantity, String enviroment) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertionMultiple = convertionMultiple;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.quantity = quantity;
        this.enviroment = enviroment;
    }

    public CurrencyConversion(UUID id, String fromCurrency, String toCurrency, Long convertionMultiple, String enviroment) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertionMultiple = convertionMultiple;
        this.enviroment = enviroment;
    }

    public CurrencyConversion(String fromCurrency, String toCurrency, Long convertionMultiple, String enviroment) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertionMultiple = convertionMultiple;
        this.enviroment = enviroment;
    }

    public CurrencyConversion() {
    }

    public CurrencyConversion(String fromCurrency, String toCurrency, Long convertionMultiple, Long totalCalculatedAmount, String enviroment) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertionMultiple = convertionMultiple;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.enviroment = enviroment;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(Long totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Long getConvertionMultiple() {
        return convertionMultiple;
    }

    public void setConvertionMultiple(Long convertionMultiple) {
        this.convertionMultiple = convertionMultiple;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public CurrencyConversion setEnviroment(String enviroment) {
        this.enviroment = enviroment;
        return this;
    }
}
