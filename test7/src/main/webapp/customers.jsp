<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/view.css" media="all">
<html>
<head>
<script type="text/javascript">
function confirm_decision(){
    if(confirm("you want to delete the user?"))
    
    { 
     
       window.location="deleteStaffAction.jsp?userID="; 
     }else{
       return false;
    }
   return true;
 }
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyBank</title>
</head>
<body>

	<%@ include file="menu.jsp"%>

	<table class="table1" align="center">
		<thead>
			<tr>
				<th scope="col">Firstname</th>
				<th scope="col">Lastname</th>
				<th scope="col">IPN</th>
				<th scope="col">Address</th>
				<th scope="col">Phone</th>
				<th scope="col">Email</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${customers}" var="customers">
				<c:set var="counter" value="${0}" />
				<tr>
					<c:forTokens items="${customers}" delims="|" var="customer">
						<c:set var="counter" value="${counter + 1}" />
						<c:if test="${counter == 3}">
							<c:set var="ipn" value="${customer}" />
						</c:if>
						<td><c:out value="${customer}" /></td>
					</c:forTokens>

					<td><a href="StorageEditor?action=edit&instance=customer&ipn=${ipn}"><img
							src="images/edit.ico" height=24 width=24></a></td>
					<td><a href="StorageEditor?action=delete&instance=customer&ipn=${ipn}" onclick="return confirm('NOOOOOOOOO!!!! Are you sure you want to delete customer with IPN ${ipn}?');"><img
							src="images/delete.ico" height=24 width=24></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
