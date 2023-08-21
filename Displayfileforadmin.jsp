<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver");%>
<HTML>
       <HEAD>
       <TITLE>NGO list </TITLE>
       <style>
        body {
        font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("https://www.shutterstock.com/shutterstock/photos/1618830400/display_1500/stock-vector-ngo-logo-symbol-design-template-1618830400.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        
          }
    </style>
       </HEAD>
       <BODY >
       <H1>The View Of Database Table </H1>
       <%
           Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ngo1","root","sql@123");
           Statement statement = connection.createStatement() ;
          ResultSet resultset = statement.executeQuery("select * from ngos") ;
       %>
       <form action="deletengo" method="post">
      <TABLE BORDER="1">
      <TR>
      <TH>photo</TH>
      <TH>ngo name</TH>
      <TH>contact</TH>
      <TH>address</TH>
      <TH>email</TH>
      <TH>work </TH>
      
    
      </TR>
      <% 
      while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getBinaryStream(8) %></TD>
       <TD> <%= resultset.getString(2) %></td>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getString(4) %></TD>
       <TD> <%= resultset.getString(5) %></TD>
       <TD> <%= resultset.getString(7) %></TD>
       <td><button type="submit" href="deletengo?id=" <%=resultset.getInt(1) %>">Delete</button>
       
      </TR>
      <%  } %>
     </TABLE>
     </form>
     </BODY>
</HTML>
    