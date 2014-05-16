<%--
  Created by IntelliJ IDEA.
  User: jerome.roethlisberge
  Date: 16.05.14
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
	<link href="./../bootstrap/css/bootstrap.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add New Person</title>
</head>
<body>

<h1>Add New Person</h1>

<c:url var="saveUrl" value="/spfg/persons/add" />
<form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input path="firstName"/></td>
		</tr>

		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName"/></td>
		</tr>

		<tr>
			<td><form:label path="money">Money</form:label></td>
			<td><form:input path="money"/></td>
		</tr>
	</table>

	<input type="submit" value="Save" />
</form:form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./../bootstrap/js/bootstrap.js"></script>
</body>
</html>