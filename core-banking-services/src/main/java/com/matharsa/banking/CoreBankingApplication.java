package com.matharsa.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreBankingApplication {

    public static void main(String[] args) {
        System.out.println("🏦 Initializing Core Banking Web Service Infrastructure...");
        SpringApplication.run(CoreBankingApplication.class, args);
    }
}
