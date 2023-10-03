<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>
<body>
	<h2>HR Admin Login</h2>
	<form:form method="POST" action="/Admin/createUser"
		modelAttribute="admin">
		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td><form:label path="adminemail">Username</form:label></td>
				<td><form:input path="adminemail" /></td>
			</tr>
			<tr>
				<td><form:label path="admin_password">Password</form:label></td>
				<td><form:password path="admin_password" /></td>
			</tr>
			<tr>
				<td><form:label path="admin_status">Confirm Password</form:label></td>
				<td><form:password path="admin_status" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create" /></td>
			</tr>
		</table>
	</form:form>
</body>

</html>