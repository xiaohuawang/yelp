package aixia1;


import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


	@WebServlet("/Input")
	public class Input extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	       
	        static Connection conn;
	        
	    public Input() {
	        super();
	        
	    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	System.out.println("doGet");
	   try {
           String url = "jdbc:oracle:thin:system/password@localhost";
            Class.forName("oracle.jdbc.driver.OracleDriver");
           //properties for creating connection to Oracle database
           Properties props = new Properties();
           props.setProperty("user", "system");
           props.setProperty("password", "62811610");
          
           //creating connection to Oracle database using JDBC
           
               conn = DriverManager.getConnection(url,props);
           } catch (Exception e) { 
        	   e.printStackTrace();
           }
	   
	  
	   String uname = request.getParameter("uname");
   	   String uemail = request.getParameter("uemail");
       String uzip = request.getParameter("uzip");
      
       System.out.println(uname);
       System.out.println(uemail);
       System.out.println(uzip);
	   
	   try {
		   
		   String sql="Insert into users(uname, uemail,uzip) values ('" + uname + "', '" + uemail + "', " + uzip + ")";  	
           PreparedStatement preStatement = conn.prepareStatement(sql);
           ResultSet result = preStatement.executeQuery();
           result.next();


       } catch (SQLException e) {

           e.printStackTrace();
       }

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		  //RequestDispatcher rd = request.getRequestDispatcher("Gradebook");
	       // rd.forward(request, response);

      }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    
}




}