/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.sise.personal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pe.edu.sise.personal.be.Persona;
import pe.edu.sise.personal.be.Usuario;

/**
 *
 * @author alumno
 */
public class ConexionDAO {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pstm = null;

    protected final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/sise_db?user=root&password=1234";

    public ConexionDAO() {
        try {
            //Paso 1 --> Cargar el driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Se establecio la conexion");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int guardarPersona(Persona persona) {

        int resultado = 0;

        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "insert into persona(nombres, apellidos, direccion) values(?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, persona.getNombres());
            pstm.setString(2, persona.getApellidos());
            pstm.setString(3, persona.getDireccion());
            resultado = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int updatePersona(Persona persona) {
        int resultado = 0;

        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "update persona set nombres=?, apellidos=?, direccion=? where id_persona=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, persona.getNombres());
            pstm.setString(2, persona.getApellidos());
            pstm.setString(3, persona.getDireccion());
            pstm.setLong(4, persona.getId());
            resultado = pstm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public List<Persona> listarPersona() {
        List<Persona> personas = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "select * from persona";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getLong(1));
                p.setNombres(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDireccion(rs.getString(4));
                personas.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personas;
    }

    public Usuario loginUsuario(Usuario usuario) {

        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "select usuario,CAST(AES_DECRYPT(password,'sise') AS CHAR(50)) as"
                    + " password from usuario where usuario=? and estado=1";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getUsuario());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String usuario_bd = rs.getString(1);
                String password_bd = rs.getString(2);
                if (usuario.getUsuario().equalsIgnoreCase(usuario_bd)
                        && usuario.getPassword().equalsIgnoreCase(password_bd)) {
                    return usuario;
                }

            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Persona buscarPersona(Long Id) {
        Persona p = null;
        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "select * from persona where id_persona = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, Id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Persona();
                p.setId(rs.getLong(1));
                p.setNombres(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDireccion(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;

    }

    //eliminar persona po id
    public int eliminarPersona(Long id_persona) {

        int num = 0;
        try {
            conn = DriverManager.getConnection(CADENA_CONEXION);
            String sql = "delete from persona where id_persona=?";
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id_persona);
            num = pstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

}
