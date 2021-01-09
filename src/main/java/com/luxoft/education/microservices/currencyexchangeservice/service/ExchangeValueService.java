package com.luxoft.education.microservices.currencyexchangeservice.service;

import com.luxoft.education.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueService {

    ExchangeValue findByFromAndTo(String from, String to);

}
