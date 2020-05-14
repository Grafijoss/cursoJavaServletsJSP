<%@page errorPage="/WEB-INF/manejoErrores.jsp"%>
<%@page import="utilerias.Conversiones, java.util.Date"%>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%> <!--Sciptle-->
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br />
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripción</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <th>1. Fundamentos de Java</th>
                <th>Aprenderemos la sintaxis basica de Java</th>
                <th><%= Conversiones.format("500")%></th>
            </tr>
            <tr>
                <th>1. Programación con Java</th>
                <th>Pondremos en practica conceptos de la programación orientada a objetos</th>
                <th><%= Conversiones.format(new Date())%></th>
            </tr>
        </table>
    </body>
</html>
