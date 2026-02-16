package com.abc.servlets;

import com.abc.dao.ProductDAO;
import com.abc.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
  private final ProductDAO dao = new ProductDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
      int id = Integer.parseInt(req.getParameter("id"));
      Product p = dao.read(id);
      if (p == null) {
        resp.getWriter().write("Product not found");
        return;
      }
      req.setAttribute("product", p);
      RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
      rd.forward(req, resp);
    } catch (Exception e) {
      resp.getWriter().write("Error: " + e.getMessage());
    }
  }
}