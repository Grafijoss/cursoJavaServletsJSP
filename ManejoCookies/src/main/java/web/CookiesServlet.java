package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        // Supongamos que el usuario visita por primera vez
        boolean nuevoUsuario = true;
        
        // Obtenemos el arrelo de cookies
        Cookie[] cookies =  request.getCookies();
        
        // Buscamos si existe una cookie
        // llamadavisitaRecurrente
        if(cookies != null){
            for(Cookie c: cookies) {
                if(c.getName().equals("visitaRecurrente")){
                    // si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break; // rompemos el ciclo
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitaRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar nuestro sitio nuevamente";
        }
        
        response.setContentType("text/hetml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: " + mensaje);
        out.close();
        
    }
}
