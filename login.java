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
public class login extends HttpServlet {

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
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         if ( validate.checkUser(username,password))
         { RequestDispatcher rs = request.getRequestDispatcher("welcome");
         rs.forward(request, response);
         HttpSession session = request.getSession();
         session.setAttribute("username",username);
         
        }
     else
         { out.print("<p class='form-control text-danger' style='text-align:center'>");
           out.print("username or Password you enter is incorrect");
           out.print("</p>");
           
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
           
         }
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rs = request.getRequestDispatcher("index.html");
        rs.include(request, response);      
    }

   
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
}
