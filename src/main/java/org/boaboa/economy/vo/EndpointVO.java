package org.boaboa.economy.vo;

import java.io.Serializable;

public class EndpointVO implements Serializable {
  private static final long serialVersionUID = -8280767960288535030L;

  public static final String INDICADOR_RESOURCE = "/indicadores";
  public static final String SERIE_RESOURCE = INDICADOR_RESOURCE + "/{indicator}/series";
  public static final String VERSION_1 = "/v1";

  private EndpointVO() {}
}
