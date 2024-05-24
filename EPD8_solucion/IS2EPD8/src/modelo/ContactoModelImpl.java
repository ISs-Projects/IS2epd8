/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ContactoController;
import java.util.List;
import modelo.persistencia.ContactoDAO;
import modelo.persistencia.JDBC.ContactoDAOJDBC;
import modelo.persistencia.file.ContactoDAOFile;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoModelImpl implements ContactoModel {

    private ContactoController controller;

    public ContactoController getController() {
        return controller;
    }

    public void setController(ContactoController controller) {
        this.controller = controller;
    }

    public void nuevoContacto(Contacto contacto) {
        ContactoDAO dao = obtenerImplementacionContactoDAO();
        dao.create(contacto);
        fireModelChanged();
    }

    public void eliminarContacto(Contacto contacto) {
        ContactoDAO dao = obtenerImplementacionContactoDAO();
        dao.delete(contacto);
        fireModelChanged();
    }

    public Contacto obtenerContacto(String nombre) {
        ContactoDAO dao = obtenerImplementacionContactoDAO();
        return dao.read(nombre);
    }

    public void actualizarContacto(Contacto contacto) {
        ContactoDAO dao = obtenerImplementacionContactoDAO();
        dao.update(contacto);
        fireModelChanged();

    }

    public List<Contacto> obtenerContactos() {
        ContactoDAO dao = obtenerImplementacionContactoDAO();
        return dao.list();
    }

    private ContactoDAO obtenerImplementacionContactoDAO() {
        //return new ContactoDAOFile();
        return new ContactoDAOJDBC();
    }

    protected void fireModelChanged() {
        getController().fireDataModelChanged();
    }
}
