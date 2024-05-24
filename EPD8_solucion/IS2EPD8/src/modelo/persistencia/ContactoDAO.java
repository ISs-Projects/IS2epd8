/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.util.List;
import modelo.Contacto;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface ContactoDAO {

    Contacto read(String pk);

    void create(Contacto contacto);

    void update(Contacto contacto);

    void delete(Contacto contacto);

    List<Contacto> list();

}
