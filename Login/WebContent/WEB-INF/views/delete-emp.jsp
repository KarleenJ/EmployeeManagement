<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
<div align="center">
		<form:form action="deleteEmployee" method="post" modelAttribute="employee">
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Dept Id</td>
					<td><form:input path="DeptId" /></td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td><form:input path="startDate" /></td>
				</tr>		
				<tr>
				<td><a href="deleteEmployee?empId=${employee.id}">Delete Employee</a></td>
				</tr>			
				</table>
		</form:form>
	</div>

</body>
</html>