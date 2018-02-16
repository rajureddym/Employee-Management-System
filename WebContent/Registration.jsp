<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee Module</title>
<center>
	<font size="5" color="red"><b><i><u>Registration
					Page</u></i></b></font>
</center>
</head>
<body bgcolor="lightgreen">
	<form
		action="http://localhost:8888/EMS_WEBSERVICES_EXAMPLE/rest/empcontroller/saveEmployee"
		method="POST">
		<table border="1">
			<tr>
				<td>Employee Number</td>
				<td><input type="number" name="empNumber" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Job</td>
				<td><input type="text" name="empJob" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Boss Code</td>
				<td><input type="number" name="empBossCode" required="required" /></td>
			</tr>
			<tr>
				<td>Employee DOJ</td>
				<td><input type="date" name="empDoj" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><input type="number" name="empSalary" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Commission</td>
				<td><input type="number" name="empComm" required="required" /></td>
			</tr>
			<tr>
				<td>Employee Department Number</td>
				<td><input type="number" name="empDeptNumber"
					required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" required="required" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>