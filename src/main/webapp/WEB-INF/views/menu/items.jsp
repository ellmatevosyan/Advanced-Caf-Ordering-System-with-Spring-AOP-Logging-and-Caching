<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/22/2024
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Name</th>
            <th>Descriptio</th>
            <th>Price</th>
            <th>Category  </th>
        </tr>
        <%
            List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            if (menuItems != null) {
                for (MenuItem menuItem : menuItems) {
        %>
        <tr>
            <td><%= menuItem.getName() %></td>
            <td><%= menuItem.getDescription() %></td>
            <td><%= menuItem.getPrice() %></td>
            <td><%= menuItem.getCategory() %></td>
        </tr>
        <%}
        }
        %>
    </table>

</body>
</html>
