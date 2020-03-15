package org.boaboa.economy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.boaboa.economy.service.IndicadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.boaboa.economy.vo.EndpointVO.INDICADOR_RESOURCE;
import static org.boaboa.economy.vo.EndpointVO.VERSION_1;

@Tag(name = "Indicadores", description = "Operaciones para indicadores")
@RestController
@RequestMapping(VERSION_1 + INDICADOR_RESOURCE)
@Slf4j
public class IndicadorController {

  private final IndicadorService service;

  public IndicadorController(IndicadorService service) {
    this.service = service;
  }

  @Operation(description = "Lista los indicadores disponibles")
  @ApiResponse(responseCode = "200", description = "Indicadores consultados exitosamente")
  @GetMapping
  public List<String> getavailableIndicators() {
    log.info("Consultando indicadores disponibles");
    return service.getAvailableIndicators();
  }
}
