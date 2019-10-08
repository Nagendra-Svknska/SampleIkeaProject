<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
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

tr:hover {
  background-color: grey;
}
</style>
<script>
	function getFullDtls(cust_id)
		{
			/* var someVariable = cust_id; */
			    
			    document.getElementById("customerID_val").value = cust_id;
				document.getElementById("myForm").submit();
		}
</script>
</head>
<body>
<jsp:include page="index.jsp" />  
<h2>Customer Details</h2>



<%-- <c:forEach items="${Customer_List}" var="cst_val">
         	${cst_val.name}<br>
         	${cst_val.city}<br>
         	${cst_val.customerId}
		</c:forEach> --%>

<form id ="myForm" name="myForm" action="getCustomerDtls">
<table>
<thead>
  <tr>
    <th>Customer ID</th>
    <th>Customer Name</th>
  </tr>
 </thead>
 <tbody>
	
 	<c:forEach items="${Customer_List}" var="cst_val">
 	
		   <tr onclick="getFullDtls('${cst_val.customerId}')">
		     <td >${cst_val.customerId}</td>
		     <td>${cst_val.fName}</td>
		   </tr>
		</c:forEach>
 </tbody>
</table>
  <input type="hidden" name="customerID_val" id="customerID_val"/>
  </form>
</body>
</html>
