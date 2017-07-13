/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Puneet
 */
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        
        String firstname = request.getParameter("firstname");
        String middlename = request.getParameter("middlename");
        String lastname = request.getParameter("lastname");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String grac = request.getParameter("graduation course");
        String grayr = request.getParameter("graduation year");
        String postc = request.getParameter("post graduation course");
        String postyr = request.getParameter("post graduation year");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String dob = request.getParameter("dob");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dob);
        
        out.println("Hello");
        
        
            
        
        
      try{
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
           //creating connection with database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","puneet@049");
            PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        
            ps.setString(1, firstname);
            ps.setString(2, middlename);
            ps.setString(3, lastname);
            ps.setDate(4, sqlDate);
            ps.setString(5, grac);
            ps.setString(6, grayr);
            ps.setString(7,postc);
            ps.setString(8, postyr);
            ps.setString(9, address);
            ps.setString(10,username);
            ps.setString(11, password);
            ps.setString(12, mobile);
            ps.setString(13,email);
            
            
            
            int i = ps.executeUpdate();
            
           if(i>0)
            { request.setAttribute("username", username);
              request.setAttribute("password", password);
              request.getRequestDispatcher("/web-INF/registered.jsp").forward(request,response);
              
            }
            
           
        }
        catch (Exception se)
        { se.printStackTrace();
        }
        
        out.println("Your data has been stored successfully");

   

      }
    
}
