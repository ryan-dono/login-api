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
import javax.ws.rs.POST;
/**
 *
 * @author hp
 */

@Path("studentcontroller")
public class StudentController {
    
   @GET
   @Path("/getData")
   @Produces(MediaType.APPLICATION_JSON)
   public ArrayList<Student> getDataInJSON() throws ClassNotFoundException, SQLException{
        
        ArrayList<Student> students = new ArrayList<>();
     
        String url="jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull";
        String user="root";
        String password="";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,user,password);
        String query= "SELECT * FROM `student`";
        
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            Student s=new Student();
            s.setMatriks(rs.getInt("matriks"));
            s.setName(rs.getString("name"));        
            s.setIc(rs.getString("ic"));
            s.setAge(rs.getInt("age"));
            
            students.add(s);
        }
        return students;
        
   
   }
   
   
  
   
   
}
