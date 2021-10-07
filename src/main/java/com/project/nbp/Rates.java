package com.project.nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
  
  private String currency;
  private String code;
  private String bid;
  private String ask;
  
  public Rates() {
  }
  
    public String getCurrency() {
      return currency;
    }

    public String getCode() {
      return code;
    }

    public String getBid() {
      return bid;
    }

    public String getAsk() {
      return ask;
    }
    
    @Override
    public String toString() {
        return currency+"  "+bid+"  "+ask;
  }
}