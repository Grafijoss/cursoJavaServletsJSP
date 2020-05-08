package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // Simulando los valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
            out.print("<h1>");
            out.print("Dattos correctos");
            out.print("<br/>Usuario " + usuario );
            out.print("<br/>Password " + password );
            out.print("</h1>");
        } else {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales no son correctas");
        }
        
        out.close();
        
    }
}
