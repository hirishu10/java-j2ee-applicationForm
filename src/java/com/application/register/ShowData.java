/**
 * @author rishuchowdhary
 */
package com.application.register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Database</title>");

            out.println("<style>"
                    + "* {margin:0px;padding:0px;}"
                    + "</style>");
            out.println("</head>");
            out.println("<body style=\"font-family: system-ui,sans-serif; background-color: ghostwhite;\">");

            out.println("<div style=\"width:100%;height:40vh;\">");
            //:: above parent or wrapper

            //::::::::::::::::::::::::>
            //:: Header Block Start's
            out.println("<div style=\"width:100%;height:40%;display: flex;\">");

            //:: Title section
            out.println("<div style=\"width: 30%; height: 100%; font-size: 30px; display: flex; justify-content: center; align-items: center;font-weight: 200;color: #0d2136;\">Database");
            out.println("</div>");

            //:: Update Delete section
            out.println("<div style=\"width:70%;height:100%;display: flex; justify-content: flex-end; align-items: center;padding-right:10px;\">");

            out.println("<a href=\"update\" style=\"margin-right:10px;font-size: 20px; background-color: #132339; padding: 10px; color: white; text-decoration: none;\">Update Data</a>");
            out.println("<a href=\"delete\" style=\"font-size: 20px; background-color: #132339; padding: 10px; color: white; text-decoration: none;\">Delete Data</a>");
            out.println("</div>");

            out.println("</div>");

            //::::::::::::::::::::::::>
            //:: Header Block End's
            //::::::::::::::::::::::::>
            //::::::::::::::::::::::::>
            //:: Base Block Start's
            out.println("<div style=\"width:100%;height:60%; display:flex; flex-direction:column;\">");

            //:: Query Select Input Box and Button
            out.println("<div style=\"width:100%;height:100%;\">");

            //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::>
            String userName = (request.getParameter("user_name")) == null ? "" : request.getParameter("user_name");      //::>
            String userEmail = (request.getParameter("user_email")) == null ? "" : request.getParameter("user_email");   //::>
            String userCourse = (request.getParameter("user_course")) == null ? "" : request.getParameter("user_course");//::>
            //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::> 

            out.println("<form action=\"ShowData\" style=\"width:100%;height:100%;\">");

            //:: Input Box's
            out.println("<div style=\"width:100%;height:60%;display:flex;justify-content:center;align-items:center;\">");

            out.println("<input type=\"text\" name=\"user_name\" placeholder=\"Name\" style=\"margin-right:5px; height:20px\" value=\"" + userName + "\"/>");
            out.println("<input type=\"email\" name=\"user_email\" placeholder=\"Email\" style=\"margin-right:5px; height:20px\" value=\"" + userEmail + "\"/>");
            out.println("<input type=\"text\" name=\"user_course\" placeholder=\"Course\" style=\"height:20px\" value=\"" + userCourse + "\"/>");

            out.println("</div>");
            //:: Input Box's

            //:: Button Box's
            out.println("<div style=\"width:100%;height:40%; display:flex;justify-content:center;align-items:center;\">");

            out.println("<a href=\"ShowData\" style=\"border: none; background-color: dodgerblue; color: white; margin-top: 10px; padding: 10px; cursor: pointer;text-decoration: none; margin-right:20px;\">All Data</a>");
            out.println("<input type=\"submit\" name=\"search\" value=\"Search\" style=\"border: none; background-color: dodgerblue; color: white; margin-top: 10px; padding: 10px; cursor: pointer;text-decoration: none;\"/>");

            out.println("</div>");
            //:: Button Box's

            out.println("</form>");

            out.println("</div>");

            out.println("</div>");
            //:: Query Select Input Box and Button

            //:: below parent or wrapper
            out.println("</div>");

            //:: Include the Data Component
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Template");
            requestDispatcher.include(request, response);

            out.println("</body>");
            out.println("</html>");
        }
    }

}
