package com.abc.servlets;

import com.abc.dao.ProductDAO;
import com.abc.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
  private final ProductDAO dao = new ProductDAO();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
      Product p = new Product();
      p.setId(Integer.parseInt(req.getParameter("id")));
      p.setName(req.getParameter("name"));
      p.setDescription(req.getParameter("description"));
      p.setPrice(Integer.parseInt(req.getParameter("price")));

      dao.update(p);
      resp.sendRedirect("list");
    } catch (Exception e) {
      resp.getWriter().write("Error: " + e.getMessage());
    }
  }
}