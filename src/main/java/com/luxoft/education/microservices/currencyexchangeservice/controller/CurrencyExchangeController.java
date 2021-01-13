package com.luxoft.education.microservices.currencyexchangeservice.controller;

import com.luxoft.education.microservices.currencyexchangeservice.model.ExchangeValue;
import com.luxoft.education.microservices.currencyexchangeservice.service.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Environment environment;
    private ExchangeValueService exchangeValueService;

    public CurrencyExchangeController(Environment environment,
                                      ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        System.out.println("from: " + from + " to: " + to);
        ExchangeValue exchangeValue = exchangeValueService.findByFromAndTo(from , to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("LOGGER: exchangeValue: {}", exchangeValue);
        return exchangeValue;
    }

}
