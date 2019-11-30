package org.boaboa.economy.gateway;

import cl.mindicador.Mindicador;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@FeignClient(name = "mindicador", url = "${indicador.base.url}")
@RequestMapping("/{codigo}")
public interface MindicadorClient {

  @GetMapping("/{date}")
  Mindicador getSeriesByDay(
      @PathVariable("codigo") String codigo,
      @PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date);
}
