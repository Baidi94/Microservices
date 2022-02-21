package com.baidi.currencyexchangeservice.controller;

import com.baidi.currencyexchangeservice.model.CurrencyExchange;
import com.baidi.currencyexchangeservice.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepo repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange
                = repository.findByFromAndTo(from, to);

        if(currencyExchange ==null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");

        currencyExchange.setEnvironment(port);
        System.out.println("Baidi");
        return currencyExchange;
    }
}
