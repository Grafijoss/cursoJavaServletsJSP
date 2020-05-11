package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset.UTF-8");

        HttpSession sesion = request.getSession();
        String titulo = null;

        // Pedir el atributo contador de visitas a la sesión
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        // Si es unlo, esla primera vez que accedemos a la aplicación
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        // Agregamos el nuevo valor a la sesión
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        // Mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br />");
        out.print("No. accesos al recurso: " + contadorVisitas);
        out.print("<br />");
        out.print("ID de la sesion: " + sesion.getId());

    }
}
