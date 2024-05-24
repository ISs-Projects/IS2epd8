/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joni-
 */
public class ContactoDAOJDBC implements ContactoDAO{
    
    private Persistencia conn;
    
    public ContactoDAOJDBC(){
        this.conn.getConn();
    }

    public Contacto read(String name) {
	Contacto contacto = null;
	try {	    
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(" SELECT Contactos WHERE nombre = '" + name + "';  ");
		String nombre = res.getString("nombre");
		String email = res.getString("email");
		String telefono = res.getString("telefono");
		contacto = new ContactoImpl(nombre, telefono, email);
		stmt.close();
//		conn.closeConecion();
	    }
	} catch (SQLException ex) {
            System.out.println(ex);
	}
	return contacto;
    }

    public void create(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Contacto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contacto> list() {
        List<Contacto> contactos = new ArrayList();
	try {
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM Contactos");
		System.out.println("\nNOMBRE \t\t EMAIL \t\t\t TELEFONO \n");
		while (res.next()) {
		    String nombre = res.getString("nombre");
		    String email = res.getString("email");
		    String telefono = res.getString("telefono");
		    System.out.println(nombre + " \t " + email + " \t " + telefono);
		    Contacto contacto = new ContactoImpl(nombre, telefono, email);
		    contactos.add(contacto);
		}
		res.close();
		stmt.close();
//		conn.closeConecion();
	    }
	} catch (SQLException ex) {
            System.out.println(ex);
        }
        return contactos;
    }
    
}
