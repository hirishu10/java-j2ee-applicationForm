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

public class UpdateData extends HttpServlet {

    int userId;
    String userName;
    String userEmail;
    String userGender;
    String userCourse;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //:::::::::
        JDBCCredentials credentials = JDBCCredentials.getCredentials();
        JDBCMySQLConnection mySQLConnection = new JDBCMySQLConnection();

        try {
            Class.forName(credentials.getConnector());
            mySQLConnection.createConnection(credentials.getUrl(), credentials.getUserName(), credentials.getPassWord());

            this.userId = Integer.parseInt(request.getParameter("user_id"));
            this.userName = request.getParameter("user_name");
            this.userEmail = request.getParameter("user_email");
            this.userGender = request.getParameter("user_gender");
            this.userCourse = request.getParameter("user_course");

            if (userId == 0) {
                out.println("<h2 style=\"color:red;\">Something went wrong please check user Id and try again.</h2>");
            } else {
                StringBuilder sb = new StringBuilder();

                userNameEnhance(sb, userName);
                userEmailEnhance(sb, userEmail);
                userGenderEnhance(sb, userGender);
                userCourseEnhance(sb, userCourse);

                String uniqueSelector = "Id=" + userId + ";";

                //::> System.out.println("UPDATE FormApplication SET " + sb.toString() + " WHERE " + uniqueSelector); //:Debug

                if (sb.length() > 0) {
                    mySQLConnection.updateTable("FormApplication", sb.toString(), uniqueSelector);
                    out.println("<h2 style=\"color:green;\">Data updated Successfully.</h2>");
                    out.println("UPDATE FormApplication SET " + sb.toString() + " WHERE " + uniqueSelector);

                } else {
                    out.println("<h2 style=\"color:red;\">Something went wrong please check user Id and try again.</h2>");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style=\"color:red;\">Something went wrong while updating data!</h3>");
        }

        mySQLConnection.closeStatement();
        mySQLConnection.closeConnection();
        //:::::::::

    }

    public void userNameEnhance(StringBuilder sb, String userName) {
        if (!flagFoNull(this.userName)) {
            sb.append("Name=\"").append(userName).append("\"");
        }
    }

    public void userEmailEnhance(StringBuilder sb, String userEmail) {
        if (flagFoNull(this.userName) && !flagFoNull(userEmail)) {
            sb.append("Email=\"").append(userEmail).append("\"");
        } else if (!flagFoNull(this.userName) && !flagFoNull(userEmail)) {
            sb.append(", ").append("Email=\"").append(userEmail).append("\"");
        }
    }

    public void userGenderEnhance(StringBuilder sb, String userGender) {
        if (flagFoNull(this.userEmail) && !flagFoNull(userGender)) {
            sb.append("Gender=\"").append(userGender).append("\"");
        } else if (!flagFoNull(this.userEmail) && !flagFoNull(userGender)) {
            sb.append(", ").append("Gender=\"").append(userGender).append("\"");
        }
    }

    public void userCourseEnhance(StringBuilder sb, String userCourse) {
        if (flagFoNull(this.userGender) && !flagFoNull(userCourse)) {
            sb.append("Course=\"").append(userCourse).append("\"");
        } else if (!flagFoNull(this.userGender) && !flagFoNull(userCourse)) {
            sb.append(", ").append("Course=\"").append(userCourse).append("\"");
        }
    }

    public boolean flagFoNull(String condition) {
        if (condition != null && condition.length() != 0) {
            return false;
        }

        return true;
    }

}
