package com.abc.dao;

import com.abc.db.DB;
import com.abc.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

  public void create(Product p) throws Exception {
    String sql = "INSERT INTO products (id, name, description, price) VALUES (?, ?, ?, ?)";
    try (Connection c = DB.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, p.getId());
      ps.setString(2, p.getName());
      ps.setString(3, p.getDescription());
      ps.setInt(4, p.getPrice());
      ps.executeUpdate();
    }
  }

  public Product read(int id) throws Exception {
    String sql = "SELECT id, name, description, price FROM products WHERE id = ?";
    try (Connection c = DB.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (!rs.next()) return null;
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setDescription(rs.getString("description"));
        p.setPrice(rs.getInt("price"));
        return p;
      }
    }
  }

  public List<Product> listAll() throws Exception {
    String sql = "SELECT id, name, description, price FROM products ORDER BY id";
    List<Product> out = new ArrayList<>();
    try (Connection c = DB.getConnection();
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setDescription(rs.getString("description"));
        p.setPrice(rs.getInt("price"));
        out.add(p);
      }
    }
    return out;
  }

  public void update(Product p) throws Exception {
    String sql = "UPDATE products SET name=?, description=?, price=? WHERE id=?";
    try (Connection c = DB.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, p.getName());
      ps.setString(2, p.getDescription());
      ps.setInt(3, p.getPrice());
      ps.setInt(4, p.getId());
      ps.executeUpdate();
    }
  }

  public void delete(int id) throws Exception {
    String sql = "DELETE FROM products WHERE id=?";
    try (Connection c = DB.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    }
  }
}