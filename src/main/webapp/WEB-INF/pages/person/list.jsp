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
	<link href="./../bootstrap/css/bootstrap.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List All Persons</title>
</head>
<body>
<h1>Persons</h1>

<c:url var="addUrl" value="/spfg/persons/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th colspan="3">Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${persons}" var="person">
		<c:url var="editUrl" value="/spfg/persons/edit?id=${person.id}" />
		<c:url var="deleteUrl" value="/spfg/persons/delete?id=${person.id}" />
		<tr>
			<td><c:out value="${person.firstName}" /></td>
			<td><c:out value="${person.lastName}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
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
<script src="./../bootstrap/js/bootstrap.min.js"></script>
</body>

</html>