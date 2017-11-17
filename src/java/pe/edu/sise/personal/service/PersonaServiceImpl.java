/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.service;

import java.util.List;
import javax.ejb.Stateless;
import pe.edu.sise.personal.be.Persona;
import pe.edu.sise.personal.dao.ConexionDAO;

/**
 *
 * @author alumno
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceImplLocal {

    @Override
    public void guardarPersona(Persona persona) {
        ConexionDAO conexionDAO = new ConexionDAO();
        conexionDAO.guardarPersona(persona);
    }


    @Override
    public List<Persona> allPersonal() {
        ConexionDAO conexion = new ConexionDAO();
        return conexion.listarPersona();
    }

    @Override
    public int updatePersona(Persona persona) {
        ConexionDAO conexion = new ConexionDAO();
        return conexion.updatePersona(persona);
    }



    @Override
    public int deletePersona(Long Id) {
        ConexionDAO conexion = new ConexionDAO();
        return conexion.eliminarPersona(Id);
    }

    @Override
    public Persona findPersonaById(Long Id) {
        ConexionDAO conexion = new ConexionDAO();
        return conexion.buscarPersona(Id);
    }
}
