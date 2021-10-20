package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryService{
    @Autowired
    CountryClient countryClient;

    public void justPrintIt(){
        String country = "USA";

        GetCountryResponse response = countryClient.getCountry(country);
        System.out.println(response.getCountry().getCapital());
        System.out.println(response.getCountry().getCurrency());
        System.out.println(response.getCountry().getPopulation());


    }
}
