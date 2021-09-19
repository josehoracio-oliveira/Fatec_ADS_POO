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
@WebServlet(name = "MathServlet", urlPatterns = {"/math"})
public class MathServlet extends HttpServlet {

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
            out.println("<title>Math</title>");
            out.println("<link rel="+"stylesheet"+" href=" + request.getContextPath() + "/css/styles.css"+">");
            out.println("</head>");
            
            out.println("<body>");

            out.println("<header class="+"container-header"+">");
            out.println("<h1>Resultados!</h1>");
            out.println("</header>");
            
            out.println("<main class="+"container-main"+">");
            
            out.println("<section class="+"container-padrao"+">");
                double number01 = Double.parseDouble(request.getParameter("number-01"));
                double number02 = Double.parseDouble(request.getParameter("number-02"));
                double adicao = number01+number02;
                double subtracao = number01-number02;
                double multiplicacao = number01*number02;
                double divisao = number01/number02;
                
            out.printf("<p>Segundo número = %.2f</p>", number02);
            out.printf("<p>Primeiro número = %.2f</p>", number01);
                
            out.printf("<p> %.2f + %.2f = %.2f </p>" , number01,number02,adicao);
            out.printf("<p> %.2f - %.2f = %.2f </p>" , number01,number02,subtracao);
            out.printf("<p> %.2f × %.2f = %.2f </p>" , number01,number02,multiplicacao);
            out.printf("<p> %.2f ÷ %.2f = %.2f </p>" , number01,number02,divisao);
                
            out.println("<div class="+"btn"+" >");
            out.println("<a href=" + "calculadora.html" + ">Voltar</a>");
            out.println("</div>");
            out.println("</section>");

            out.println("<div class="+"container-img"+">");
            out.println("<img src="+"img/java.png"+" alt="+"logo-java"+" />");
            out.println("</div>");

            out.println("</main>");
            
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
