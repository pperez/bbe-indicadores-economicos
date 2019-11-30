package org.boaboa.economy.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class IndicadorDTO implements Serializable {
  private static final long serialVersionUID = -6482721657981911316L;

  @ApiModelProperty(value = "Nombre del indicador", required = true)
  private String name;

  @ApiModelProperty("Valor del indicador para el dia consultado")
  private Double value;
}
