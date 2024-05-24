/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Contacto;
import modelo.ContactoImpl;
import modelo.persistencia.ContactoDAO;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoDAOJDBC implements ContactoDAO {

    public void create(Contacto contacto) {
        String sql = "insert into contactos(nombre,telefono,email) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, contacto.getNombre());
            stm.setString(2, contacto.getTelefono());
            stm.setString(3, contacto.getEmail());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Contacto read(String pk) {
        Contacto c = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM contactos where nombre=" + pk);
            String nombre, email, tlf;
            if (res.next()) {
                nombre = res.getString("nombre");
                email = res.getString("email");
                tlf = res.getString("telefono");
                c = new ContactoImpl(nombre, tlf, email);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

public void update(Contacto contacto) {
    throw new UnsupportedOperationException("Not supported yet.");
}

public void delete(Contacto contacto) {
    throw new UnsupportedOperationException("Not supported yet.");
}

    public List<Contacto> list() {
        List<Contacto> contactos = new ArrayList<Contacto>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM contactos ");
            String nombre, email, tlf;
            while (res.next()) {

                nombre = res.getString("nombre");
                email = res.getString("email");
                tlf = res.getString("telefono");
                contactos.add(new ContactoImpl(nombre,tlf,email));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return contactos;
    }
}
