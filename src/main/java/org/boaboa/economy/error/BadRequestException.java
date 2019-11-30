package org.boaboa.economy.error;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Data
@ResponseStatus(BAD_REQUEST)
public class BadRequestException extends RuntimeException {
  private static final long serialVersionUID = 6788762062741093100L;

  public BadRequestException(String message) {
    super(message);
  }
}
