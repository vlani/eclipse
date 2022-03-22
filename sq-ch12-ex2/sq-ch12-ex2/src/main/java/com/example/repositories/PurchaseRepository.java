package com.example.repositories;

import com.example.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

  private final JdbcTemplate jdbc;

  public PurchaseRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Purchase storePurchase(Purchase purchase) {
    String sql = "INSERT INTO purchase VALUES (?, ?, ?, ?)";
    jdbc.update(sql, purchase.getId(), purchase.getProduct(), purchase.getPrice(), purchase.getVersion());
    
    return purchase;    
  }

  public List<Purchase> findAllPurchases() {
    String sql = "SELECT * FROM purchase";

    RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
      Purchase rowObject = new Purchase();
      rowObject.setId(r.getInt("id"));
      rowObject.setProduct(r.getString("product"));
      rowObject.setPrice(r.getBigDecimal("price"));
      rowObject.setVersion("XXX");
      //rowObject.setVersion(r.getString("version"));
      return rowObject;
    };

    return jdbc.query(sql, purchaseRowMapper);
  }
}
