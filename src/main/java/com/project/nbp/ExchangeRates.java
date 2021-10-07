package com.project.nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {

  private String table;
  private String no;
  private String tradingDate;
  private String effectiveDate;
  private List<Rates> rates;
  
  public ExchangeRates(){
  }

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<Rates> getRates() {
        return rates;
    }
  
  @Override
  public String toString() {
      
    String str = "\nnazwa waluty  kupno  sprzedaż";
    for (Rates r : rates){
        str += "\n"+r.toString();
    }
    return str;
  }
}