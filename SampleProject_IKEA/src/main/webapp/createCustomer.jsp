<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

 input[type=submit]:hover {
  background-color: #45a049;
} 

.table_deco {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>
<jsp:include page="index.jsp" />
<h3>Create Customer Entry</h3>

<div class="table_deco">
  <form action="/CreateEntityval">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="fname" placeholder="Your name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lname" placeholder="Your last name..">

    <label for="city">City</label>
    <input type="text" id="city" name="city" placeholder="Your city name..">
    
    <label for="phn_nmbr">Contact Number</label>
    <input type="text" id="phn_nmbr" name="phn_nmbr" placeholder="Your contact Number..">
  
    <input type="submit" value="Submit">
  </form>
</div>
<div ><b>${message}</b></div>
</body>
</html>