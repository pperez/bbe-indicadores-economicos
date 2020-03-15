package org.boaboa.economy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.boaboa.economy.dto.IndicadorDTO;
import org.boaboa.economy.service.IndicadorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.boaboa.economy.vo.EndpointVO.SERIE_RESOURCE;
import static org.boaboa.economy.vo.EndpointVO.VERSION_1;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Tag(name = "Series", description = "Consulta de series para un indicador")
@RestController
@RequestMapping(VERSION_1 + SERIE_RESOURCE)
@Slf4j
public class SerieController {

  private final IndicadorService service;

  public SerieController(IndicadorService service) {
    this.service = service;
  }

  @Operation(summary = "Obtiene la serie para un dia especifico")
  @GetMapping
  public IndicadorDTO getSerie(
      @Parameter(description = "Indicador a consultar") @PathVariable("indicator") String indicator,
      @DateTimeFormat(iso = DATE)
          @Parameter(description = "Dia a consultar")
          @RequestParam(value = "dia", required = false)
          LocalDate date) {
    if (null == date) {
      log.warn("Usando fecha actual por defecto para serie de indicador [{}]", indicator);
      date = LocalDate.now();
    }
    log.info("Consultando serie de indicador [{}] para el dia [{}]", indicator, date);
    return service.getSerieByDay(indicator, date);
  }
}
