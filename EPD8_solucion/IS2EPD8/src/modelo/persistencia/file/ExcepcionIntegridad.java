/*
 * ElementoNoAlmacenado.java
 *
 * Created on 5 de noviembre de 2007, 18:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo.persistencia.file;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public class ExcepcionIntegridad extends RuntimeException{
    
    String infoExcepcion;
    /** Creates a new instance of ElementoNoAlmacenado */
    public ExcepcionIntegridad(String s) {
        infoExcepcion=s;
    }
    
}
