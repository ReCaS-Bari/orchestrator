package it.reply.orchestrator.service;

import it.reply.orchestrator.dto.slam.SlamPreferences;

public interface SlamService {

  public SlamPreferences getCustomerPreferences();

  public String getUrl();
}
