<%--
  Created by IntelliJ IDEA.
  User: jerome.roethlisberger
  Date: 16.05.14
  Time: 21:00
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
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Lists all persons">
	<meta name="author" content="Jerome Roethlisberger">
	<link rel="shortcut icon" href="../bootstrap/ico/favicon.ico">
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List All Persons</title>
</head>
<body>
<h1>List All Persons</h1>

<c:url var="addUrl" value="/spfg/persons/add" />
<a href="${addUrl}">Add a new person</a>
<table class="table table-striped">
	<thead>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th colspan="3">Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${persons}" var="person">
		<c:url var="editUrl" value="/spfg/persons/edit?id=${person.id}" />
		<c:url var="deleteUrl" value="/spfg/persons/delete?id=${person.id}" />
		<c:url var="viewUrl" value="/spfg/persons/view?id=${person.id}" />
		<tr>
			<td><c:out value="${person.firstName}" /></td>
			<td><c:out value="${person.lastName}" /></td>
			<td><c:out value="${person.email}"/> </td>
			<td><c:out value="${person.phone}" /> </td>
			<td><a href="${viewUrl}">View</a></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty persons}">
	There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>