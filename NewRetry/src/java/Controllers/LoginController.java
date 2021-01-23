/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import com.test.Student;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
/**
 *
 * @author hp
 */

@Path("logincontroller")
public class LoginController {
    
   @GET
   //@Consumes(MediaType.TEXT_PLAIN)
   @Path("/login/{username}/{password}")
   @Produces(MediaType.APPLICATION_JSON)
   public Student checkLogin(@PathParam("username") String u,@PathParam("password") String p) throws ClassNotFoundException, SQLException
  {     Student std=new Student();
        try{
        
        String url="jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull";
        String user="root";
        String dbpassword="";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,user,dbpassword);
        String query= "SELECT * FROM `student` WHERE ic=? AND name=?";
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,p);
        st.setString(2,u);
        ResultSet rs=st.executeQuery();
        if(rs.next())
        {
            
            std.setAge(rs.getInt("age"));
            std.setIc(rs.getString("ic"));
            std.setName(rs.getString("name"));
            std.setMatriks(rs.getInt("matriks"));
            //text="Your name is "+std.getName()+". Your age is "+ std.getAge();
        }       
//        return std;
         
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return std; 
          
   }
    
    
    
    
    
}
