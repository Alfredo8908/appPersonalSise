/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.service;

import java.sql.SQLException;
import javax.ejb.Stateless;
import pe.edu.sise.personal.be.Usuario;
import pe.edu.sise.personal.dao.ConexionDAO;

/**
 *
 * @author alumno
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioServiceImplLocal {

    @Override
    public Usuario login(Usuario usuario) throws SQLException, Exception {
        
        ConexionDAO conexionDAO = new ConexionDAO();
        Usuario user = conexionDAO.loginUsuario(usuario);
        return user;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
