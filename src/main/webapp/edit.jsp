<%@ page import="com.abc.model.Product" %>
<%
  Product p = (Product) request.getAttribute("product");
%>
<html><body>
<h3>Edit Product</h3>
<form action="update" method="post">
  ID: <input name="id" type="number" value="<%= p.getId() %>" readonly /><br/>
  Name: <input name="name" value="<%= p.getName() %>" required /><br/>
  Description: <input name="description" value="<%= p.getDescription() %>" required /><br/>
  Price: <input name="price" type="number" value="<%= p.getPrice() %>" required /><br/>
  <button type="submit">Update</button>
</form>
<a href="list">Back</a>
</body></html>