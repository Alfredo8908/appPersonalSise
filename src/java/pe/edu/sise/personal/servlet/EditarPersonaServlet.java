/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.sise.personal.be.Persona;
import pe.edu.sise.personal.service.PersonaServiceImplLocal;

/**
 *
 * @author alumno
 */
public class EditarPersonaServlet extends HttpServlet {
    
    @EJB
    private PersonaServiceImplLocal editarLocal; 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long IdPersonal = Long.valueOf(request.getParameter("idpersona"));
            Persona persona = editarLocal.findPersonaById(IdPersonal);
            RequestDispatcher rd = request.getRequestDispatcher("registrarPersona.jsp");
            request.setAttribute("persona",persona);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
