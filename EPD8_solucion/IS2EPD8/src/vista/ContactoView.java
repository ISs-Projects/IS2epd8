package vista;

import controlador.ContactoController;
import modelo.ContactoModel;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface ContactoView {

    ContactoController getController();

    void setController(ContactoController controller);

    ContactoModel getModel();

    void setModel(ContactoModel model);

    void dataModelChanged();

    void display();

}
