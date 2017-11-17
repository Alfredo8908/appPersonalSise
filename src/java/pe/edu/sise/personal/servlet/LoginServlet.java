/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.servlet;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.sise.personal.be.Usuario;
import pe.edu.sise.personal.service.UsuarioServiceImplLocal;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author alumno
 */
public class LoginServlet extends HttpServlet {

    @EJB    //Se llama al Interfaz
    private UsuarioServiceImplLocal usuarioLocal;

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

        try {
            String user = request.getParameter("InputUser");
            String password = request.getParameter("InputPassword");
            Usuario oUsuario = new Usuario();
            oUsuario.setUsuario(user);
            oUsuario.setPassword(password);
            oUsuario = usuarioLocal.login(oUsuario);
            
            if(oUsuario != null){
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            }else{//si no obtiene nulos
                request.setAttribute("error","1");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,null,e);
        }

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
