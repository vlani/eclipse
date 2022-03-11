package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Purchase {

  private int id;
  private String product;
  private BigDecimal price;
  private String version="3.0";

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProduct() {
    return product;
  }
  
  public void setProduct(String product) {
	    this.product = product;
  }

  public String getVersion() {
	    return version;
  }
  
  public void setVersion(String version) {
    this.version = version;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Purchase purchase = (Purchase) o;
    return id == purchase.id && Objects.equals(product, purchase.product) && Objects.equals(price, purchase.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, product, price);
  }
}
