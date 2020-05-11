package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        // Creamos o recuperamos el objeto session
        HttpSession sesion = request.getSession();

        // Recuperamos las lista de los articulos agregados si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        // Verificamos si la ista de articulos existe
        if (articulos == null) {
            // Inicializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        // Procesamos el nuevo articulo
        String nuevoArticulo = request.getParameter("articulo");

        // Revisamos y agregamos el articulo nuevo
        if (nuevoArticulo != null && !nuevoArticulo.trim().equals("")) {
            articulos.add(nuevoArticulo);
        }

        try ( // Imprimimos la lista de articulos
            PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");
            // Iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }

    }
}
