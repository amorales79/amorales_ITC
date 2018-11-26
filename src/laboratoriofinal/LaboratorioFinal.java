/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofinal;

import java.util.Scanner;
import peliculas.negocio.*;


/**
 *
 * @author alvaromorales
 */
public class LaboratorioFinal {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "/Users/alvaromorales/Desktop/LaboratorioFinal/Catalogo_Peliculas.txt";
    private static final CatalogoPeliculas catalogoPelicula = new CatalogoPeliculasImpl();

    public static void main(String[] args) {
        
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Buscar Pelicula\n"
                        + "0.- Salir");
                
                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        catalogoPelicula.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        System.out.println("coloque nombre de pelicula a agregar:");
                        String nombre = scanner.nextLine();
                        catalogoPelicula.agregarPelicula(nombre, nombreArchivo);
                        break;
                    case 3:
                        catalogoPelicula.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        System.out.println("coloque nombre de pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoPelicula.buscarPelicula(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Disfrute de las peliculas!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n"); 

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
}
    
    

