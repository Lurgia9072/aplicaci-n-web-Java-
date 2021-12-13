<%-- 
    Document   : Products
    Created on : 12/12/2021, 11:19:06 AM
    Author     : HP
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
       <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">BLAZE</a>
              </div>
              <ul class="nav navbar-nav">
                  <li class="active"><a href="index.jsp">Orders</a></li>
                  <li class=""><a href="Products.jsp">Products</a></li>
              </ul>
            </div>
        </nav>
      
        <br>
        <br>
        
      <!--- <div class="container">
            <a class="btn btn-success btn-lg" href="Controlador?accion=listar">Create Order</a>
        </div>
      
      !-->
        
        
        
         <div class="container">
            <h1>Products</h1>
            <a class="btn btn-success" href="Controlador?accion=add">Create Product</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">N°</th>
                        <th class="text-center">CONSUMMER</th>
                        <th class="text-center">STATUS</th>
                        <th class="text-center">DATE</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list=dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getConsummer()%></td>
                        <td><%= per.getStatus()%></td>
                        <td><%= per.getDate()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= per.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
                
    </body>
</html>
