/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
public class RegistrarPersonaServlet extends HttpServlet {

    @EJB
    private PersonaServiceImplLocal personaLocal;

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

        String nombre = request.getParameter("InputNombre");
        String apellido = request.getParameter("InputApellido");
        String direccion = request.getParameter("InputDireccion");
        String idPersonal = request.getParameter("InputId");        
        String MENSAJE = null; 

        Persona persona = new Persona();
        persona.setNombres(nombre);
        persona.setApellidos(apellido);
        persona.setDireccion(direccion);
        if(!idPersonal.equals("")){
            persona.setId(Long.valueOf(idPersonal));
            personaLocal.updatePersona(persona);
            MENSAJE = "Actualizaron";
        }
        try {
            personaLocal.guardarPersona(persona);
        } catch (Exception ex) {
            Logger.getLogger(RegistrarPersonaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        MENSAJE = "Guardaron";    
         
        request.setAttribute("msg", "El registro se guardo correctamente");
        request.getRequestDispatcher("/registrarPersona.jsp").forward(request, response);        

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
