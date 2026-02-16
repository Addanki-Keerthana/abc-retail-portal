package com.abc.servlets;

import com.abc.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/list")
public class ListProductsServlet extends HttpServlet {
  private final ProductDAO dao = new ProductDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try {
      req.setAttribute("products", dao.listAll());
      RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
      rd.forward(req, resp);
    } catch (Exception e) {
      resp.getWriter().write("Error: " + e.getMessage());
    }
  }
}