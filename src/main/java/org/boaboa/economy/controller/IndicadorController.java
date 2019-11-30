package org.boaboa.economy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.boaboa.economy.service.IndicadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.boaboa.economy.vo.EndpointVO.INDICADOR_RESOURCE;
import static org.boaboa.economy.vo.EndpointVO.VERSION_1;

@Api(tags = "Indicadores", description = "Operaciones para indicadores")
@RestController
@RequestMapping(VERSION_1 + INDICADOR_RESOURCE)
@Slf4j
public class IndicadorController {

  private final IndicadorService service;

  public IndicadorController(IndicadorService service) {
    this.service = service;
  }

  @ApiOperation("Lista los indicadores disponibles")
  @ApiResponses({@ApiResponse(code = 200, message = "Indicadores consultados exitosamente")})
  @GetMapping
  public List<String> getavailableIndicators() {
    log.info("Consultando indicadores disponibles");
    return service.getAvailableIndicators();
  }
}
