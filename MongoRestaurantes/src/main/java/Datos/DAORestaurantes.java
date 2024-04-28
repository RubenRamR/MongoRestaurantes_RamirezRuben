/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelos.Restaurante;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Aggregates.match;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author rramirez
 */
public class DAORestaurantes {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAORestaurantes() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("Empresas");
        collection = database.getCollection("Restaurantes");
    }

    public void agregarRestaurante(Restaurante restaurante) {
        Document DocRestaurante = new Document("nombre", restaurante.getNombre()).append("rating", restaurante.getRating()).
                append("fechaInauguracion", restaurante.getFechaInauguracion()).append("categorias", restaurante.getCategorias());

        collection.insertOne(DocRestaurante);
    }

    public void agregarCategoriaExtra(String nombreRestaurante, String categoriaNueva) {
        Document filtro = new Document("nombre", nombreRestaurante);

        Bson actualizacion = Updates.push("categorias", categoriaNueva);

        UpdateResult res = collection.updateOne(filtro, actualizacion);

        if (res.getModifiedCount() > 0)
        {
            System.out.println("Se agrego la categoria '" + categoriaNueva + "' al restaurante '" + nombreRestaurante + "'.");
        } else
        {
            System.out.println("No se encontro el restaurante '" + nombreRestaurante + "'. No se realizo ninguna actualizacion.");
        }
    }

    public void consultarPorRaiting(int rating) {
        Document matchStage = new Document("$match", new Document("rating", new Document("$gt", rating)));

        AggregateIterable<Document> res = collection.aggregate(Arrays.asList(matchStage));

        for (Document doc : res)
        {
            System.out.println(doc.toJson());
        }
    }

    public void consultarPorCategoria(String categoria) {
        Document matchStage = new Document("$match", new Document("categorias", categoria));

        AggregateIterable<Document> res = collection.aggregate(Arrays.asList(matchStage));

        for (Document doc : res)
        {
            System.out.println(doc.toJson());
        }
    }

    public void consultarPorNombre(String nombre) {
        Document matchStage = new Document("$match", new Document("nombre", Pattern.compile(nombre, Pattern.CASE_INSENSITIVE)));

        AggregateIterable<Document> res = collection.aggregate(Arrays.asList(matchStage));

        for (Document doc : res)
        {
            System.out.println(doc.toJson());
        }
    }

    public void eliminarRestaurantePorId(String id) {
        ObjectId ObjectId = new ObjectId(id);

        collection.deleteOne(Filters.eq("_id", ObjectId));
    }

    public void eliminarPorRaitingMenorA(int rating) {
        Bson filtro = Filters.lt("rating", rating);

        DeleteResult res = collection.deleteMany(filtro);

        if (res.getDeletedCount() > 0)
        {
            System.out.println("Se eliminaron " + res.getDeletedCount() + " restaurantes con rating menor a " + rating + ".");
        } else
        {
            System.out.println("No se encontraron restaurantes con rating menor a " + rating + ".");
        }
    }

}
