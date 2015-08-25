package aixia1;

import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//This retrieves information from the gradebook

@WebServlet("/ReadR")
public class ReadR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Connection conn;
	
    public ReadR() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String all = "";
		Double average = 0.0;
		
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

		// StudentID, Assignment, AssignType, AssignDate, Grade
		
		/*
		create table reviews
		(
		rid varchar(100) primary key,
		rest_id integer,
		user_id varchar(50),
		rdate varchar(50),
		rcomment varchar(50),
		rating number(2,1)
		);
		*/
		
		    try {
		    	PreparedStatement preStatement = conn.prepareStatement("select * from reviews"); 
				ResultSet result = preStatement.executeQuery();
				while (result.next())
				{
		    		all += "<tr>";
		    		all += "<td>";
		    		all += result.getString("rid");
		    		all+= "</td>";
		    		all += "<td>";
		    		all += result.getInt("rest_id");
		    		all+= "</td>";
		    		all += "<td>";
		    		all += result.getString("user_id");
		    		all+= "</td>";
		    		all += "<td>";
		    		all += result.getString("rdate");
		    		all+= "</td>";
		    		all += "<td>";
		    		all += result.getString("rcomment");
		    		all+= "</td>";
		    		all += "<td>";
		    		
		    		
		    		
		    		all+= result.getDouble("rating");
		    		all+= "</td>";
		    		all += "</tr>";
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		
			request.setAttribute("all", all);
			getServletContext().getRequestDispatcher("/ReadR.jsp").forward(request, response);
			
			/*
			try{
				PreparedStatement preStatement = conn.prepareStatement("select avg(grade) as average from grades");
				ResultSet result = preStatement.executeQuery();
				result.next();
				average = result.getDouble("average");
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String averagestring = String.format("%.2f", average);
			request.setAttribute("average", averagestring);
			getServletContext().getRequestDispatcher("/allBook.jsp").forward(request, response);
		    
		     */
	}
         

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}