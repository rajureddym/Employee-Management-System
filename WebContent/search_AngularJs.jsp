<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX with Servlets using AngularJS</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	function MyController($scope, $http) {
		$scope.getDataFromServer = function() {
			$http(
					{
						method : 'GET',
						url : 'http://localhost:8888/EMS_WEBSERVICES_EXAMPLE/rest/empcontroller/getemp/'
								+ $scope.employeeNumber
					}).success(function(data, status, headers, config) {
				$scope.employeeVO = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		};
	};
</script>
</head>
<body>
	<div data-ng-app="myApp">
		<div data-ng-controller="MyController">
			<div>
				<label>Employee Number:</label> <input
					data-ng-model="employeeNumber" type="number">
			</div>
			<button data-ng-click="getDataFromServer()">Employee Data</button>
			<!-- <table>
				<tr>
					<td><font color="red">{{employeeVO.errorMsg}}</font></td>
					<td><font color="red">{{employeeVO.statusCode}}</font></td>
				</tr>
			</table> -->
			<table border="1">
				<tr>
					<th>Number</th>
					<th>Name</th>
					<th>Job</th>
					<th>Boss Code</th>
					<th>DOJ</th>
					<th>Basic</th>
					<th>Commission</th>
					<th>Department Number</th>
				</tr>
				<tr>
					<td>{{employeeVO.empNumber}}</td>
					<td>{{employeeVO.empName}}</td>
					<td>{{employeeVO.empJob}}</td>
					<td>{{employeeVO.empBossCode}}</td>
					<td>{{employeeVO.empDoj}}</td>
					<td>{{employeeVO.empSalary}}</td>
					<td>{{employeeVO.empCommission}}</td>
					<td>{{employeeVO.empDepartmentNumber}}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>

