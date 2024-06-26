package modelo;

import java.io.Serializable;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface Contacto extends Serializable {

    String getEmail();

    String getNombre();

    String getTelefono();

    void setEmail(String email);

    void setNombre(String nombre);

    void setTelefono(String tlf);

}
