/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author rramirez
 */
public class Restaurante {

    ObjectId id;
    String nombre;
    int rating;
    String fechaInauguracion;
    List<String> categorias;

    public Restaurante() {
    }

    public Restaurante(String nombre, int rating, String fechaInauguracion, List<String> categorias) {
        this.nombre = nombre;
        this.rating = rating;
        this.fechaInauguracion = fechaInauguracion;
        this.categorias = categorias;
    }

    public Restaurante(ObjectId id, String nombre, int rating, String fechaInauguracion, List<String> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.fechaInauguracion = fechaInauguracion;
        this.categorias = categorias;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(String fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Restaurantes{" + "id=" + id + ", nombre=" + nombre + ", rating=" + rating + ", fechaInauguracion=" + fechaInauguracion + ", categorias=" + categorias + '}';
    }

}
