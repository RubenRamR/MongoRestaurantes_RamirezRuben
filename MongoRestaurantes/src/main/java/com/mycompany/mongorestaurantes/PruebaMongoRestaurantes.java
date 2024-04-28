/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mongorestaurantes;

import Datos.DAORestaurantes;
import Modelos.Restaurante;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rramirez
 */
public class PruebaMongoRestaurantes {
    
    public static void main(String[] args) {
        DAORestaurantes r = new DAORestaurantes();

        //ArrayList<Restaurante> lista = r.obtenerRestaurantes();
//        Restaurante r1 = new Restaurante("La Justa", 4, "2015-01-01", Arrays.asList("Pizza", "Comida Mexicana"));
//        Restaurante r2 = new Restaurante("Sushilito", 4, "2018-10-01", Arrays.asList("Sushi", "Comida China"));
//        Restaurante r3 = new Restaurante("Deshuesadero", 2, "2020-01-20", Arrays.asList("Pizza", "Sushi", "Hamburguesas"));
//
//        r.agregarRestaurante(r1);
//        r.agregarRestaurante(r2);
//        r.agregarRestaurante(r3);
        //r.consultarPorRaiting(4);
        //r.consultaPorCategoria("Pizza");
        //r.consultarPorNombre("sushi");
        //r.agregarCategoriaExtra("Sushilito", "Italiana");
        
        //Restaurante r4 = new Restaurante("RRR", 2, "ruuuru", Arrays.asList("p", "o"));
        //r.agregarRestaurante(r4);
        //r.eliminarRestaurantePorId("662dcae66b2efd786ca5f5df");
        
        r.eliminarPorRaitingMenorA(3);
    }
}
