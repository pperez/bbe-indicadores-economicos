package org.boaboa.economy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BbeIndicadoresEconomicosApplication {

  public static void main(String[] args) {
    SpringApplication.run(BbeIndicadoresEconomicosApplication.class, args);
  }
}
