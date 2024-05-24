/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import modelo.persistencia.*;
import java.util.List;
import modelo.Contacto;
import modelo.ContactoImpl;

/**
 *
 * @author Norberto Díaz-Díaz
 */


public class ContactoDAOFile implements ContactoDAO {

    private static String fileName = "MisContactos.txt";

    public void create(Contacto contacto) {
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(fileName, "rw");


            if (read(contacto.getNombre()) == null) {
                file.seek(file.length());
                file.write(contacto.toString().getBytes());
            } else {
                throw new ExcepcionIntegridad("Ya existe el contacto: " + contacto.getNombre());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero " + fileName);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public Contacto read(String nombre) {
        FileReader fr = null;
        BufferedReader bf = null;
        Contacto contacto = null;
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);

            boolean found = false;
            String linea;
            while ((linea = bf.readLine()) != null && !found) {
                String[] campos = linea.split("\t");
                if (nombre.equals(campos[0])) {
                    contacto = new ContactoImpl(campos[0], campos[1], campos[2]);
                    found = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bf.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            return contacto;
        }
    }

    public void update(Contacto contacto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Contacto contacto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Contacto> list() {
        List<Contacto> contactos = new ArrayList();
        FileReader fr = null;
        BufferedReader bf = null;

        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);

            String linea;
            while ((linea = bf.readLine()) != null) {
                contactos.add(read((linea.split("\t"))[0]));
            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bf.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            return contactos;
        }
    }
}
