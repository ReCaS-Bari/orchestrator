/*
 * Copyright © 2015-2020 Santer Reply S.p.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.reply.orchestrator.config.security;

import it.reply.orchestrator.config.properties.OidcProperties;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@ConditionalOnProperty(value = OidcProperties.SECURITY_ENABLED_PROPERTY, havingValue = "false",
    matchIfMissing = true)
public class AnonimousWebSecurityConfig extends BaseWebSecurityConfig {

  @Override
  public void configure(@NonNull HttpSecurity http) throws Exception {
    super.configure(http);
    http
        .authorizeRequests()
        .anyRequest()
        .anonymous();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
