<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 3/22/2024
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Order Details</h2>

    <div>Order id - ${order.orderId}</div>
    <div>Order Time - ${order.orderTime}</div>
    <div>Order table number - ${order.tableNumber}</div>
    <div>Order waiter id - ${order.waiterId}</div>
    <div>Order name - ${menuItem.name}</div>
    <div>Order quantity - ${orderItem.quantity}</div>
    <div>Order price - ${menuItem.price}</div>

</body>
</html>
