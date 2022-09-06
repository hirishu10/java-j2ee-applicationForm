/**
 * @author rishuchowdhary
 */
package com.application.register;

import JdbcMySQLConnector.Concreate.JDBCCredentials;
import JdbcMySQLConnector.Concreate.JDBCMySQLConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class Template extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Database</title>");

        out.println("<style>"
                + "* {margin:0px;padding:0px;}"
                + "</style>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body style=\"font-family: system-ui,sans-serif;\">");

        out.println("<div style=\"width:100%;height:60vh;display:flex; justify-content:center;align-items:flex-start;\" class=\"container\">");
        //:: above parent or wrapper

        String userName = request.getParameter("user_name");
        String userEmail = request.getParameter("user_email");
        String userCourse = request.getParameter("user_course");

        if (userName == null && userEmail == null && userCourse == null) {
            printAllData(out);// Print all the Results;    
        } else {

            if (userName.length() == 0 && userEmail.length() == 0 && userCourse.length() == 0) {
                printAllData(out);// Print all the Results;    
            } else {
                printCustomData(out, userName, userEmail, userCourse);// Print all the Results with custom parameter's;  
            }
        }

        //:: below parent or wrapper
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");

    }

    public void printAllData(PrintWriter out) {
        //:::::::::
        JDBCCredentials credentials = JDBCCredentials.getCredentials();
        JDBCMySQLConnection mySQLConnection = new JDBCMySQLConnection();

        out.println("<table style=\"border: 1px solid black;\" class=\"table table-bordered border-primary\"> ");
        out.println("<tr style=\"background-color: black;color: antiquewhite;\">");
        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Id");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Name");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Email");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Gender");
        out.println("</td>");

        out.println("<td style=\"text-align: center;    padding: 0px 10px 0px 10px;\">");
        out.println("Courses");
        out.println("</td>");

        out.println("</tr>");

        //::> Print All Data
        try {
            Class.forName(credentials.getConnector());
            mySQLConnection.createConnection(credentials.getUrl(), credentials.getUserName(), credentials.getPassWord());

            ResultSet set = mySQLConnection.getAllData("FormApplication");

            while (set.next()) {

                out.println("<tr>");
                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getInt(1));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(2));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(3));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(4));
                out.println("</td>");

                out.println("<td style=\"text-align: center;    padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(5));
                out.println("</td>");

                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style=\"color:red;\">Something went wrong while fetching data from the server</h3>");
        }

        out.println("</table>");
        mySQLConnection.closeConnection();
        //:::::::::
    }

    public void printCustomData(PrintWriter out, String userName, String userEmail, String userCourse) {
        //:::::::::
        JDBCCredentials credentials = JDBCCredentials.getCredentials();
        JDBCMySQLConnection mySQLConnection = new JDBCMySQLConnection();

        out.println("<table style=\"border: 1px solid black;\" class=\"table table-bordered border-primary\">");
        out.println("<tr style=\"background-color: black;color: antiquewhite;\">");
        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Id");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Name");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Email");
        out.println("</td>");

        out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
        out.println("Gender");
        out.println("</td>");

        out.println("<td style=\"text-align: center;    padding: 0px 10px 0px 10px;\">");
        out.println("Courses");
        out.println("</td>");

        out.println("</tr>");

        //::> Print All Data // Working
        try {
            Class.forName(credentials.getConnector());
            mySQLConnection.createConnection(credentials.getUrl(), credentials.getUserName(), credentials.getPassWord());

            String SQLQuery = "SELECT * FROM FormApplication WHERE Name=\"" + userName + "\" OR Email=\"" + userEmail + "\" OR Course=\"" + userCourse + "\";";
            ResultSet set = mySQLConnection.otherQuerySQL(SQLQuery);

            while (set.next()) {

                out.println("<tr>");
                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getInt(1));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(2));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(3));
                out.println("</td>");

                out.println("<td style=\"border-right: 1px solid black;text-align: center;padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(4));
                out.println("</td>");

                out.println("<td style=\"text-align: center;    padding: 0px 10px 0px 10px;\">");
                out.println(set.getString(5));
                out.println("</td>");

                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style=\"color:red;\">Something went wrong while fetching data from the server</h3>");
        }

        out.println("</table>");
        mySQLConnection.closeConnection();
        //:::::::::
    }

}
