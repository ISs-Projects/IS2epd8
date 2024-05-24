/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author joni-
 */
public interface ContactoDAO {
    Contacto read(String s);
    public void create(Contacto c);
    public void update(Contacto c);
    public void delete(Contacto c);
    List<Contacto> list();        
}
