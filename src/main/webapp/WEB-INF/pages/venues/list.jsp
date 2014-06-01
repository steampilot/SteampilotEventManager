<%--
  Created by IntelliJ IDEA.
  User: jerome.roethlisberger
  Date: 01.06.14
  Time: 01:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" content="">
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

<c:url var="addUrl" value="/venues/add"/>
<a href="${addUrl}">Add a new venue</a>
<table class="table table-striped">
	<thead>
	<tr>
		<th>Title</th>
		<th>Description</th>
		<th>Location</th>
		<th>Contact Person</th>
		<th>Actions</th>
	</tr>
	</thead>
	<tbody>

	<%--@elvariable id="venues" type="ch.steampilot.spem.controller.VenueController"--%>
	<c:forEach items="${venues}" var="venue">
		<c:url var="editUrl" value="/venues/edit?id=${venue.id}"/>
		<c:url var="deleteUrl" value="/persons/delete?id=${venue.id}"/>
		<tr>
			<td><c:out value="${venue.title}"/></td>
			<td><p><c:out value="${venue.description}"/></p></td>
			<td><c:out value="${venue.address1}"/> <br>
				<c:out value="${venue.address2}"/> <br>
				<c:out value="${venue.zipCode} ${venue.city}"/> <br>
				<c:out value="${venue.country}"/>
			</td>
			<td><c:out value="${venue.keeperFirstName} ${venue.keeperLastName}"/> <br>
				<c:out value="${venue.keeperEmail}"/><br>
				<c:out value="${venue.keeperPhone}"/>
			</td>
			<td><a href="${editUrl}">Edit</a><br>
				<a href="${deleteUrl}">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty venues}">
	There are currently no venues in the list. <a href="${addUrl}">Add</a> a venue.
</c:if>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="javascript"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>