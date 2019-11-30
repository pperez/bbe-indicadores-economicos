package org.boaboa.economy.service;

import org.boaboa.economy.dto.IndicadorDTO;

import java.time.LocalDate;
import java.util.List;

public interface IndicadorService {

  List<String> getAvailableIndicators();

  IndicadorDTO getSerieByDay(String indicator, LocalDate date);
}
