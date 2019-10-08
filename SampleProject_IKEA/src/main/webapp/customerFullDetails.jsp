<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<jsp:include page="index.jsp" />  
<h2>Customer Details</h2>

<table>
<thead>
  <tr>
    <th>Customer ID</th>
    <th>Customer First Name</th>
    <th>Customer Last Name</th>
    <th>City</th>
    <th>Contact Number</th>
    <!-- <th>City</th> -->
  </tr>
 </thead>
 <tbody>
	
 	<c:forEach items="${Customer_List}" var="cst_val">
		   <tr>
		     <td id="${cst_val.customerId}">${cst_val.customerId}</td>
		     <td>${cst_val.fName}</td>
		     <td>${cst_val.lName}</td>
		     <td>${cst_val.city}</td>
		     <td>${cst_val.cntctNumber}</td>
		     <%-- <td>${empList.address}</td> --%>
		   </tr>
		</c:forEach>
 </tbody>
</table>

</body>
</html>
