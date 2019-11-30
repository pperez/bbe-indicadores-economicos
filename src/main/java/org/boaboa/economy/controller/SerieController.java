package org.boaboa.economy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.boaboa.economy.dto.IndicadorDTO;
import org.boaboa.economy.service.IndicadorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static org.boaboa.economy.vo.EndpointVO.SERIE_RESOURCE;
import static org.boaboa.economy.vo.EndpointVO.VERSION_1;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Api(tags = "Series", description = "Consulta de series para un indicador")
@RestController
@RequestMapping(VERSION_1 + SERIE_RESOURCE)
@Slf4j
public class SerieController {

  private final IndicadorService service;

  public SerieController(IndicadorService service) {
    this.service = service;
  }

  @ApiOperation("Obtiene la serie para un dia especifico")
  @GetMapping
  public IndicadorDTO getSerie(
      @ApiParam("Indicador a consultar") @PathVariable("indicator") String indicator,
      @DateTimeFormat(iso = DATE) @ApiParam("Dia a consultar") @RequestParam("dia")
          LocalDate date) {
    log.info("Consultando serie de indicador [{}] para el dia [{}]", indicator, date);
    return service.getSerieByDay(indicator, date);
  }
}
