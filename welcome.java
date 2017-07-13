/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author Puneet
 */
public class welcome extends HttpServlet {

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
        String firstname = null;
        String lastname = null;
        String name = request.getParameter("username");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","puneet049");
            PreparedStatement s = con.prepareStatement("select firstname,lastname from student where username = ?");
            s.setString(1, name);
            
            ResultSet rs = s.executeQuery();
            if (rs.next())
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
           }
        catch (Exception se)
        { 
            se.printStackTrace();
        }
      request.setAttribute("username",name);
      request.setAttribute("firstname", firstname);
      request.setAttribute("lastname", lastname);
      request.getRequestDispatcher("/WEB-INF/logged.jsp").forward(request,response);
    
    }
        
}

