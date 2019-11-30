package org.boaboa.economy.service.impl;

import cl.mindicador.Mindicador;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.boaboa.economy.dto.IndicadorDTO;
import org.boaboa.economy.error.BadRequestException;
import org.boaboa.economy.gateway.MindicadorClient;
import org.boaboa.economy.service.IndicadorService;
import org.boaboa.economy.util.converter.IndicadorConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class IndicadorServiceImpl implements IndicadorService {

  private final MindicadorClient client;
  private final IndicadorConverter converter;
  private final List<String> availableIndicators;

  public IndicadorServiceImpl(
      MindicadorClient client,
      IndicadorConverter converter,
      @Value("${indicador.enabled-indicators}") List<String> availableIndicators) {
    this.client = client;
    this.converter = converter;
    this.availableIndicators = availableIndicators;
  }

  @Override
  public List<String> getAvailableIndicators() {
    log.info("Consultando indicadores disponibles");
    return availableIndicators;
  }

  @Override
  public IndicadorDTO getSerieByDay(String indicator, LocalDate date) {
    log.info("Consultando serie [{}] para fecha [{}]", indicator, date);

    // Checkeo si el indicador esta definido
    boolean indicadorValido =
        StringUtils.equalsAnyIgnoreCase(indicator, availableIndicators.toArray(new String[0]));

    if (!indicadorValido) {
      log.error("El indicador ingresado no es valido [{}]", indicator);
      throw new BadRequestException("Indicador no disponible");
    }

    Mindicador indicador = client.getSeriesByDay(indicator, date);
    log.info("Consultado serie para indicador [{}] en fecha [{}]", indicator, date);

    return converter.convert(indicador);
  }
}
