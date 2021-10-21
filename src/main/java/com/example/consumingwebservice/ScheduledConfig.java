package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledConfig {
    @Autowired
    CountryClient client;

    int i = 0;

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void doSomething(){
        i++;
        GetCountryResponse response = client.setCountry("COUNTRY" + i, "CAPITAL" + i, i, "CUR" + i);
        System.out.printf("%s %s %s %n", response.getCountry().getName(), response.getCountry().getCapital(), response.getCountry().getPopulation());
    }
}