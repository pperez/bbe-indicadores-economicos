package org.boaboa.economy.config;

import feign.Feign;
import feign.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ConditionalOnClass({Feign.class})
public class AppFeignConfiguration {

  // Workaround ya que spring registra los mappings usados por feign
  @Bean
  public WebMvcRegistrations feignWebRegistrations() {
    return new FeignMvcRegistration();
  }

  private static class FeignMvcRegistration implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
      return new FeignFilterRequestMappingHandlerMapping();
    }

    private static class FeignFilterRequestMappingHandlerMapping
        extends RequestMappingHandlerMapping {
      @Override
      protected boolean isHandler(Class<?> beanType) {
        return super.isHandler(beanType)
            && (AnnotationUtils.findAnnotation(beanType, FeignClient.class) == null);
      }
    }
  }

  // Tener el logging de clientes feign, solo cuando dejamos debug=true en algun property source
  @ConditionalOnProperty("debug")
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
