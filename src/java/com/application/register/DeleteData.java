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

public class DeleteData extends HttpServlet {

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

            int userId = Integer.parseInt(request.getParameter("user_id"));

            if (userId == 0) {
                out.println("<h2 style=\"color:red;\">Something went wrong please check user Id and try again.</h2>");
            } else {

                String SQLStatement = "DELETE FROM FormApplication WHERE Id=" + userId + ";";
                mySQLConnection.otherOperationSQL(SQLStatement);

                out.println("<h2 style=\"color:green;\">Data Deleted Successfully.</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style=\"color:red;\">Something went wrong while deleting data!</h3>");
        }

        mySQLConnection.closeStatement();
        mySQLConnection.closeConnection();
        //:::::::::

    }
}
