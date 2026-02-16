<%@ page import="java.util.List" %>
<%@ page import="com.abc.model.Product" %>

<%
  List<Product> products = (List<Product>) request.getAttribute("products");
%>

<html><body>
<h3>Products</h3>
<table border="1" cellpadding="6">
  <tr>
    <th>ID</th><th>Name</th><th>Description</th><th>Price</th><th>Actions</th>
  </tr>

  <%
    for (Product p : products) {
  %>
    <tr>
      <td><%= p.getId() %></td>
      <td><%= p.getName() %></td>
      <td><%= p.getDescription() %></td>
      <td><%= p.getPrice() %></td>
      <td>
        <a href="edit?id=<%= p.getId() %>">Edit</a> |
        <a href="delete?id=<%= p.getId() %>">Delete</a>
      </td>
    </tr>
  <%
    }
  %>
</table>

<br/>
<a href="index.jsp">Home</a>
</body></html>