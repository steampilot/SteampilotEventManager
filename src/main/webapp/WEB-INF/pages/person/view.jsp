<%--
  Created by IntelliJ IDEA.
  User: jerome.roethlisberge
  Date: 17.05.14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Adds a new person">
	<meta name="author" content="Jerome Roethlisberger">
	<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Existing Person</title>
</head>
<body>

<h1>Edit Existing Person</h1>
<table class="table table-striped" >
	<tr>
		<th>First Name</th>
		<td><c:out value="${personAttribute.firstName}"/> </td>
	</tr>
	<tr>
		<th>First Name</th>
		<td><c:out value="${personAttribute.lastName}"/> </td>
	</tr>
	<tr>
		<th>First Name</th>
		<td><c:out value="${personAttribute.birthday}"/> </td>
	</tr>
	<tr>
		<th>Email</th>
		<td><c:out value="${personAttribute.email}"/> </td>
	</tr>
	<tr>
		<th>Phone</th>
		<td><c:out value="${personAttribute.phone}"/> </td>
	</tr>
	<tr>
		<th>Address 1</th>
		<td><c:out value="${personAttribute.address1}"/> </td>
	</tr>
	<tr>
		<th>Address 2</th>
		<td><c:out value="${personAttribute.address2}"/> </td>
	</tr>
	<tr>
		<th>Zip Code</th>
		<td><c:out value="${personAttribute.zipcode}"/> </td>
	</tr>
	<tr>
		<th>City</th>
		<td><c:out value="${personAttribute.city}"/> </td>
	</tr>
	<tr>
		<th>Country</th>
		<td><c:out value="${personAttribute.country}"/> </td>
	</tr>
</table>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html