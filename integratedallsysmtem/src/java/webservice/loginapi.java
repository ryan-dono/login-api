/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package webservice;
import Middleware.SignIn;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import jdbc.UserDAO;

/**
 *
 * @author hp
 */

@Path("loginapi")
public class loginapi {
    
      
    private UserDAO jdbcUtility;
    private Connection con;
    

    //for understanding sake - please rename as User or Alumni
    //im pretty sure this `database` is a user right
    @GET
    @Path("/login/{email}/{password}") //this is also called part of a URL
    //1st step
    //The web app must receive input from mobile app
    //hence thats why in the path put {email}/{password}
    // which means that is where the input will be inserted from the mobile api
    
    //in the mobile app we will call this URL
    
    
    //2nd step
    // the PathParam job is to take the parameter, email and password from the URL or in this case the
    // /login/{email}/{password} 
    // then it will put the parameter value inside wemail and wpassword (which stands for web email and web password) 
    //indicating that the email input
    // is now inside the web app
    //
    public database getDataInJSON(@PathParam("email") String wemail, @PathParam("password") String wpassword) throws ServletException, IOException, SQLException, ClassNotFoundException
    {
       
        
        //3rd step
        //now that we have the email and password from mobile input
        //we need to verify that input in the database to check if the user is valid or not
       //actually since you have done the checklogin function for the web input we can just use that
       //so....
        
        database User=new database();
        String driver = "com.mysql.jdbc.Driver"; 
        String dbName = "sdadatabase";
        String url = "jdbc:mysql://localhost/" + dbName + "?";
        String userName = "root";
        String dbpassword = "";
        
        SignIn si=new SignIn();
        UserDAO userJDBC=new UserDAO(driver,url,userName,dbpassword);
        userJDBC.jdbcConnect();
        
        si=userJDBC.checkLogin(wemail, wpassword);
        
        //4th step
        //if si == null means the mobile user is invalid so return an invalid user
        //else if not null means mean mobile user is valid, so return a the User object or in this case
        // the database object . 
        //so we must find that specific user first then we return to the mobile api back
        
        
        if(si!=null)
        {
             con = userJDBC.jdbcGetConnection();
            String query = "select * from alumniuser where Email = ? and password = ?";
             try{
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1, wemail);
                ps.setString(2,wpassword);
                ResultSet rs=ps.executeQuery();
               
               while(rs.next())
                    {
                       
                        User.setAddress(rs.getString("Address"));
                        User.setCurrentJob(rs.getString("CurrentJob"));
                        User.setQualification(rs.getString("qualification"));
                        User.setEmail(rs.getString("Email"));
                        User.setGraduateYear(rs.getInt("GraduateYear"));
                        User.setName(rs.getString("Name"));
                        User.setPassword(rs.getString("password"));
                        User.setPhone(rs.getString("PhoneNo"));
                        User.setPreviousJob(rs.getString("PreviousJob"));
                        User.setSalaryCurrent(rs.getDouble("SalaryCurrent"));
                        User.setSalaryPrevious(rs.getDouble("SalaryPrevious"));
                        User.setStatus(rs.getString("Status"));
                       
                    }   

        
         
        }
             catch(SQLException ex) {
                System.out.println(ex.getMessage());
            } 
            
            
            
        }
        else
        {
          User=null;  
        }
         
        return User;
    
    
    
}
    
    //this is just for testing
    
    @GET
    @Path("/test")
    public String test()
    {
        return "test";
    }
}