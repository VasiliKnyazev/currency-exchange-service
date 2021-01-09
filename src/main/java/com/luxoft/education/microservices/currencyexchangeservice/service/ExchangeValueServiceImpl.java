package com.luxoft.education.microservices.currencyexchangeservice.service;

import com.luxoft.education.microservices.currencyexchangeservice.dao.ExchangeValueRepository;
import com.luxoft.education.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {

    private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValueServiceImpl(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
