/**
 * @author rishuchowdhary
 */
package com.application.register;

import JdbcMySQLConnector.Concreate.JDBCCredentials;
import JdbcMySQLConnector.Concreate.JDBCMySQLConnection;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterApplication extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String name = request.getParameter("user_name");
            String email = request.getParameter("user_email");
            String gender = request.getParameter("user_gender");
            String course = request.getParameter("user_course");
            String terms = request.getParameter("user_terms");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterApplication</title>");
            out.println("</head>");
            out.println("<body>");

            // Check user fill each row
            if (name.length() == 0
                    || email.length() == 0
                    || gender.length() == 0
                    || course.length() == 0
                    || terms == null) {
                out.println("<h3 style=\"color:red;\">Sorry! you have not filled the form carefully. Please check and try again.</h3>");

                //Include method helps to add any other servlet inside the current survlet
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
                requestDispatcher.include(request, response);
            } else {
                out.println("<h1 style=\"color:dodgerblue;\">Thank You for filling the Form " + name + "</h1>");
                out.println("<h4>Your Name: " + name + "</h4>");
                out.println("<h4>Your Email Id: " + email + "</h4>");
                out.println("<h4>You are: " + gender + "</h4>");
                out.println("<h4>Thank you for taking our " + course + " course. which you will get for free.</h4>");

                //Adding data inside Database with the help of JDBC
                try {

                    JDBCCredentials credentials = JDBCCredentials.getCredentials();
                    Class.forName(credentials.getConnector());

                    JDBCMySQLConnection mySQLConnection = new JDBCMySQLConnection();
                    mySQLConnection.createConnection(credentials.getUrl(), credentials.getUserName(), credentials.getPassWord());

                    String customizeStringValue = "\"" + name + "\"," + "\"" + email + "\"," + "\"" + gender + "\"," + "\"" + course + "\"";
                    mySQLConnection.insertDataInsideTable("FormApplication", "Name,Email,Gender,Course", customizeStringValue);

                    mySQLConnection.closeStatement();
                    mySQLConnection.closeConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}
