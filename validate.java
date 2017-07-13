/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Puneet
 */
import java.sql.*;

public class validate {
    public static boolean checkUser(String user, String pass){
        boolean st = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/database","root","puneet@049");
             PreparedStatement ps = con.prepareStatement
                             ("select * from student where username=? and password=?");
             ps.setString(1, user);
             ps.setString(2, pass);
             ResultSet rs = ps.executeQuery();
             st = rs.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return st;
    }
}