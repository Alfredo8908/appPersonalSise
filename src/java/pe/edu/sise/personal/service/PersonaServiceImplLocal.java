/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.service;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import pe.edu.sise.personal.be.Persona;

/**
 *
 * @author alumno
 */
@Local
public interface PersonaServiceImplLocal {
    public List<Persona> allPersonal();
    public void guardarPersona(Persona persona) throws SQLException, Exception;
    public int updatePersona(Persona persona);
    public Persona findPersonaById(Long Id);
    public int deletePersona(Long Id);
//    public List<Persona> listarPersona();
        
    
    
}
