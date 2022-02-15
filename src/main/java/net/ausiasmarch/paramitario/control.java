package net.ausiasmarch.paramitario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class control extends HttpServlet {

    private String celda(String contenido) {
        return "<td>" + contenido + "</td>";
    }

    private String fila(String contenido) {
        return "<tr>" + contenido + "</tr>";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejer01peticionHTTP</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\n"
                   + "integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />");
            out.println("</head>");

            out.println("<body>");

            out.println("<div class=\"d-flex justify-content-center m-2 p-2\">");
            out.println("<h2>paramitario</h2>");
            out.println("</div>"); //col

            out.println("<div class=\"d-flex justify-content-between m-2 p-2\">");

            //out.println("<div class=\"row\">");
            out.println("<div class=\"p-2\">");
            out.println("<h3>Parámetros de sistema</h3>");
            out.println("<table class=\"table table-sm\">");
            out.println("<tr><th>Parametro</th><th>Valor</th></tr>");
            out.println(fila(celda("Protocolo:") + celda(request.getProtocol())));
            out.println(fila(celda("Método:") + celda(request.getMethod())));
            out.println(fila(celda("URI:") + celda(request.getRequestURI())));
            out.println(fila(celda("URL:") + celda(request.getRequestURL().toString())));
            out.println(fila(celda("Context Path:") + celda(request.getContextPath())));
            out.println(fila(celda("Codificación:") + celda(request.getCharacterEncoding())));
            out.println(fila(celda("Tipo mime:") + celda(request.getContentType())));
            out.println(fila(celda("IP recepción:") + celda(request.getLocalAddr())));
            out.println(fila(celda("Nombre ifaz. recepción:") + celda(request.getLocalName())));
            out.println(fila(celda("Path:") + celda(request.getPathInfo())));
            out.println(fila(celda("PrePath:") + celda(request.getPathTranslated())));
            out.println(fila(celda("IP remota:") + celda(request.getRemoteAddr())));
            out.println(fila(celda("Host remoto:") + celda(request.getRemoteHost())));
            out.println(fila(celda("IP remota:") + celda(request.getProtocol())));
            out.println(fila(celda("Nombre del host remoto:") + celda(request.getServerName())));
            out.println(fila(celda("Puerto:") + celda(((Integer) request.getServerPort()).toString())));
            out.println("</table>");
            out.println("</div>"); //col

            out.println("<div class=\"p-2\">");
            out.println("<h3>Cabeceras</h3>");
            out.println("<table class=\"table table-sm\">");
            out.println("<tr><th>Cabecera</th>");
            out.println("<th>Valor</th></tr>");
            Enumeration cabeceras = request.getHeaderNames();
            while (cabeceras.hasMoreElements()) {
                String cabecera = (String) cabeceras.nextElement();
                out.println("<tr><td>" + cabecera + "</td >");
                out.println("<td>" + request.getHeader(cabecera) + "</td></tr>");
            }
            out.println("</table>");
            out.println("</div>"); //col

            out.println("<div class=\"p-2\">");
            out.println("<h3>Parámetros de usuario</h3>");
            out.println("<table class=\"table table-sm\">");
            out.println("<tr><th>Parametro</th><th>Valor</th></tr>");
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String parametro = (String) parametros.nextElement();
                out.println("<tr><td>" + parametro + "</td><td>");
                String[] valores = request.getParameterValues(parametro);
                if (valores.length == 1) {
                    String paramValue = valores[0];
                    if (paramValue.length() == 0) {
                        out.print("Vacío");
                    } else {
                        out.println(paramValue);
                    }
                } else {
                    out.print("<b>Array: </b>");
                    for (int i = 0; i < valores.length; i++) {
                        out.println(valores[i] + " ");
                    }
                }
                out.print("</td>");
            }
            out.println("</table>");

            out.println("</div>"); //col

            out.println("</div>"); //row

            out.println("<div class=\"d-flex justify-content-center m-2 p-2\">");
            out.println("<a CLASS=\"btn btn-primary\" href=\"index.html\">Volver al índice</a>");
            out.println("</div>"); //row

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
