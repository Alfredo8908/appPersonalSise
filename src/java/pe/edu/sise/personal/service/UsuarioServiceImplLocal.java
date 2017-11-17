/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.service;

import java.sql.SQLException;
import javax.ejb.Local;
import pe.edu.sise.personal.be.Usuario;

/**
 *
 * @author alumno
 */
@Local
public interface UsuarioServiceImplLocal {
    
    public Usuario login(Usuario usuario) throws SQLException, Exception;
    
    
}
