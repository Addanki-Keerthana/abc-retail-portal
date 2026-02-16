package com.abc.servlets;

import com.abc.dao.ProductDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
  private final ProductDAO dao = new ProductDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
      int id = Integer.parseInt(req.getParameter("id"));
      dao.delete(id);
      resp.sendRedirect("list");
    } catch (Exception e) {
      resp.getWriter().write("Error: " + e.getMessage());
    }
  }
}