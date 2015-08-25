<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="Input.jsp">Home</a> 
    </div>
    <div>
      <ul class="nav navbar-nav">
      
		

      </ul>
    </div>
  </div>
</nav>


<div class="container">
  <h2>Vertical (basic) form</h2>
 <form role="form" action="Input" method="POST">
    
    <div class="form-group">
      <label for="uname">Name:</label>
      <input type="uname" name="uname" class="form-control" id="uname" placeholder="Enter name">
    </div>
    
    <div class="form-group">
    <label for="uemail">Zipcode:</label>
    <input type = "uemail" name="uemail" class="form-control" id="uemail" placeholder="Enter email">
    </div>
   
   
    <div class="form-group">
    <label for="uzip">Zipcode:</label>
    <input type = "uzip" name="uzip" class="form-control" id="uzip" placeholder="Enter zipcode">
  </div>
   
  
   
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  </div>
 



</body>
</html>
