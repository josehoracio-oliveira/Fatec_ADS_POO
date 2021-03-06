/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose Horacio
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juros-composto.html"})
public class JurosCompostosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");

                out.println("<head>");
                    out.println("<title>Calculadora de Juros Composto</title>");
                    out.println("<link rel=" + "stylesheet" + " href=" + request.getContextPath() + "/css/styles.css" + ">");
                out.println("</head>");
                
                out.println("<header class=" + "container-header" + ">");
                    out.println("<h1>Juros Composto Servlet</h1>");
                out.println("</header>");

                out.println("<main class=" + "container-main" + ">");
                out.println("<section class=" + "container-padrao" + ">");

                
                out.println("<head>");
                    out.println("<title>Calculadora de Juros Composto</title>");            
                out.println("</head>");
                
                out.println("<body>");
                    out.println("<h1>Resultado:</h1>");
                        double VP = Double.parseDouble(request.getParameter("VP"));
                        int N = Integer.parseInt(request.getParameter("N"));
                        double i = Double.parseDouble(request.getParameter("i"));
                        double VF = VP* Math.pow(1+(i/100),N);

                        out.printf("<p>Valor Presente = R$ %.2f</p>", VP);    
                        out.printf("<p>Meses = %d</p>", N);
                        out.printf("<p>Taxa de juros = %.2f</p>", i);
                        out.printf("<p>Valor Futuro = R$ %.2f</p>", VF);

                        out.println("<div class=" + "btn" + " >");
                            out.println("<a href=" + "index.html" + ">Voltar</a>");
                        out.println("</div>");
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
