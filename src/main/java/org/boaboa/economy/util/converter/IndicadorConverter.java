package org.boaboa.economy.util.converter;

import cl.mindicador.Mindicador;
import cl.mindicador.Serie;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.boaboa.economy.dto.IndicadorDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class IndicadorConverter implements Converter<Mindicador, IndicadorDTO> {
  @Override
  public IndicadorDTO convert(Mindicador mindicador) {
    log.debug("Convirtiendo respuesta de mindicador [{}]", mindicador);
    IndicadorDTO.IndicadorDTOBuilder builder = IndicadorDTO.builder();

    Optional<Serie> serie = mindicador.getSerie().stream().findFirst();

    builder.name(StringUtils.trimToNull(mindicador.getNombre()));

    if (serie.isPresent()) {
      builder.value(serie.get().getValor());
    } else {
      log.warn("No se encontraron series para el dia consultado");
    }

    IndicadorDTO dto = builder.build();
    log.debug("Convertida respuesta de mindicador [{}]", dto);
    return dto;
  }
}
