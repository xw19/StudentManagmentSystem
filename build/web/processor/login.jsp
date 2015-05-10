<%-- 
    Document   : login
    Created on : 10 May, 2015, 4:14:03 PM
    Author     : sourav
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.JConn" %>
<%@page import="authentication.Authenticate" %>


<%
            String user = request.getParameter("User");
            String password = Authenticate.hashit(request.getParameter("password"));
            //out.print(user + " " + password + "<br>" );
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            try {
                conn = JConn.dbconnection();
                ps = conn.prepareStatement("SELECT * FROM employee WHERE emp = ? and password = ?");
                ps.setString(1, user);
                ps.setString(2, password);
                rs = ps.executeQuery();

                if (rs.next()) {
//                    out.print("success");
                    String user_id = rs.getString(2);
                    String type = rs.getString(5);
                    session.setAttribute("user", user_id);
                    session.setAttribute("type", type);
                    response.sendRedirect("../pages/index.jsp");
                } else {
                    response.sendRedirect("../index.html");
                }
            } catch (Exception e) {
                out.print("Error: " + e);
            } finally {
                if (rs != null ) {
                    rs.close();
                }
                if (ps != null ) {
                    ps.close();
                }
                if (conn != null ) {
                    conn.close();
                }
            }
%>