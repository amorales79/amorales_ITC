/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import peliculas.dominio.*;
import peliculas.excepciones.*;

/**
 *
 * @author alvaromorales
 */
public class AccesoDatosImpl implements AccesoDatos {

        
    public boolean exists(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return peliculas;
    }
  
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)  throws EscrituraDatosEx  {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha ingresado correctamente informacion de pelicula");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   
    public String buscar(String buscar, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en catalogo de peliculas " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado correctamente informacion de pelicula");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado informacion de peliculas");
    }
}
    

