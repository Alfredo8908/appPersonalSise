/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.dao;

import java.util.List;
import pe.edu.sise.personal.be.Persona;

/**
 *
 * @author alumno
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Insertar
        
//        ConexionDAO conexion = new ConexionDAO();
//        Persona persona = new Persona();
//        persona.setNombres("Alfredo");
//        persona.setApellidos("Salvador");
//        persona.setDireccion("ate vitarte");
//        
//        int resultado = conexion.guardarPersona(persona);
//        System.out.println("Resultado" + resultado);
        
        
//        Actualizar
        
//         ConexionDAO conexion = new ConexionDAO();
//        Persona persona = new Persona();
//        persona.setId(new Long("3"));
//        persona.setNombres("Alfredo");
//        persona.setApellidos("Salvador Vargas");
//        persona.setDireccion("La Menacho");
//        
//        int resultado = conexion.actualizarPersona(persona);
//        System.out.println("Resultado" + resultado);
        
        ConexionDAO conexion = new ConexionDAO();
        List<Persona> personas = conexion.listarPersona();
        for(Persona p:personas){
            System.out.println("Nombre" + p.getNombres());
            System.out.println("Apellidos" + p.getApellidos());
            System.out.println("Direccion" + p.getDireccion());
    }
    }
    
}
