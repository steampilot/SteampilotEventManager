<%--
  Created by IntelliJ IDEA.
  User: jerome.roethlisberger
  Date: 17.05.14
  Time: 10:17
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
	<title>Edit Existing Venue</title>
</head>
<body>

<h1>Edit Existing Venue</h1>
<c:url var="saveUrl" value="/venues/edit?id=${venueAttribute.id}" />
<form:form cssClass="form-horizontal" modelAttribute="venueAttribute" method="POST" action="${saveUrl}">
	<div class="form-group">
		<form:label cssClass="col-sm-2 control-label" path="title">Title:</form:label>
		<form:input cssClass="form-control" path="title"/>
	</div>
	<div class="form-group">
		<form:label cssClass="col-sm-2 control-label" path="description">Description:</form:label>
		<form:input cssClass="form-control" path="description"/>
	</div>
	<div class="form-group">
		<form:label cssClass="col-sm-2 control-label" path="address1">Address 1:</form:label>
		<form:input cssClass="form-control" path="address1"/>
	</div>
	<div>
		<form:label cssClass="col-sm-2 conrol-label" path="address2">Address 2:</form:label>
		<form:input cssClass="form-control" path="address2"/>
	</div>
	<div>
		<form:label cssClass="col-sm-2 conrol-label" path="zipCode">Zip Code:</form:label>
		<form:input cssClass="form-control" path="zipCode"/>
	</div>
	<div>
		<form:label cssClass="col-sm-2 conrol-label" path="city">City:</form:label>
		<form:input cssClass="form-control" path="city"/>
	</div>
	<div class="form-group">
		<form:label cssClass="col-sm-2 control-label" path="country">Country:</form:label>
		<form:input cssClass="form-control" path="country"/>
	</div>
	<div class="form-group">
		<input type="submit" class="btn btn-primary" value="Save" />
	</div>
</form:form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>