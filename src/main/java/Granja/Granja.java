
package Granja;

import Granja.Archivo.Archivo;
import Granja.clases.Animales;
import Granja.clases.TiposAnimales;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;


/**
 * @author Nicoh
 */
public class Granja {


    public static void main(String[] args) throws IOException {

        Set<Animales> listAnimals = new HashSet<>();
        Archivo archivo = new Archivo("Animales.txt");

        Scanner leerNumero = new Scanner(System.in);
        Scanner leerString = new Scanner(System.in);

        String opcion = "0";
        System.out.println("Menu");
        System.out.println("1.- Listar Animal");
        System.out.println("2.- Listar Animales");
        System.out.println("3.- Agregar Animal");
        System.out.println("4.- Alimentar Animal");
        System.out.println("5.- Alimentar Animales");
        System.out.println("6.- Jugar con Animal");
        System.out.println("7.- Jugar con Animales");
        System.out.println("8.- Descansar Animal");
        System.out.println("9.- Descansar Animales");
        System.out.println("-------------------------");
        System.out.println("* Para salir ingrese: exit");
        System.out.println("* para limpiar ingrese: clean");
        System.out.println("* para guardar datos de sistema ingrese: save");
        System.out.println("* para cargar datos del sistema ingrese: load");
        while (!opcion.equals("11")) {
            opcion = leerNumero.nextLine();
            switch (opcion) {
                case "1":
                    listarAnimal(listAnimals,leerString);
                    break;
                case "2":
                    listarAnimales(listAnimals);
                    break;
                case "3":
                    agregarAnimal(leerString,listAnimals);
                    break;
                case "4":
                    alimentarAnimal(leerString,listAnimals);
                    break;
                case "5":
                    alimentarAnimales(listAnimals);
                    break;
                case "6":
                    jugarConAnimal(leerString,listAnimals);
                    break;
                case "7":
                    jugarConAnimales(listAnimals);
                    break;
                case "8":
                    descansarAnimal(leerString,listAnimals);
                    break;
                case "9":
                    descansarAnimales(listAnimals);
                    break;
                case "load":
                    listAnimals.addAll(archivo.cargarAnimales());
                    break;
                case "save":
                    archivo.save(listAnimals);
                    break;
                case "exit":
                    opcion = "11";
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion No valida");
                    break;

            }

        }
    }

    private static void listarAnimales(Set<Animales> listAnimals) {
        if (!listAnimals.isEmpty()) {
            listAnimals.forEach(System.out::println);

        } else {
            System.out.println("No fueron cargados los datos.");
        }
    }

    private static void listarAnimal(Set<Animales> listAnimals, Scanner leerString){
        System.out.println("Escribe el Nombre");
        String nombre = leerString.nextLine();
        Optional<Animales> resultado = listAnimals.stream().filter(animal -> animal.getNombre().equals(nombre)).findFirst();
        if (resultado.isPresent()) {
            System.out.println(resultado.get());
        } else {
            System.out.println("No existe el animal");
        }
    }

    private static void agregarAnimal(Scanner leerString,Set<Animales> listAnimals){
        System.out.println("Escribe el Nombre");
        String nombre = leerString.nextLine();
        System.out.println("Tipo");
        String tipo = leerString.nextLine();
        try {
            Animales animal = new Animales(nombre, TiposAnimales.valueOf(tipo.toLowerCase()));
            listAnimals.add(animal);
           // archivo.agregarAnimal(animal);
            System.out.println("El animal " + animal.getNombre() + " fue creado correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo no existente en el sistema");
        }
    }

    private static void alimentarAnimal(Scanner leerString, Set<Animales> listAnimals){
        System.out.println("Escribe el Nombre");
        String nombre = leerString.nextLine();
        Optional<Animales> resultado = listAnimals.stream().filter(animal -> animal.getNombre().equals(nombre)).findFirst();

        if (resultado.isPresent()) {
            System.out.println(resultado.get());
            System.out.println("Alimentando animal...");
            resultado.get().alimentar();
            System.out.println(resultado.get());
        } else {
            System.out.println("El animal no existe");
        }
    }

    private static void alimentarAnimales(Set<Animales> listAnimals){
        listAnimals.forEach(animales -> System.out.println(animales.toString()));
        System.out.println("Alimentando animales...");
        listAnimals.forEach(Animales::alimentar);
        listAnimals.forEach(animales -> System.out.println(animales.toString()));
    }

    private static void jugarConAnimal(Scanner leerString, Set<Animales> listAnimals){
        System.out.println("Escribe el nombre");
        String nombre = leerString.nextLine();
        Optional<Animales> resultado = listAnimals.stream().filter(animal -> animal.getNombre().equals(nombre)).findFirst();
        if (resultado.isPresent()) {
            System.out.println(resultado.get());
            resultado.get().jugar();
            System.out.println("Jugando con el animal...");
            System.out.println(resultado.get());
        } else {
            System.out.println("El animal no existe");
        }
    }

    private static void jugarConAnimales(Set<Animales> listAnimals){
        listAnimals.forEach(System.out::println);
        listAnimals.forEach(Animales::jugar);
        System.out.println("Jugando con los animales...");
        listAnimals.forEach(System.out::println);
    }


    private static void descansarAnimal(Scanner leerString, Set<Animales> listAnimals){
        System.out.println("Escribe el nombre");
        String nombre = leerString.nextLine();
        Optional<Animales> resultado = listAnimals.stream().filter(animal -> animal.getNombre().equals(nombre)).findFirst();
        if (resultado.isPresent()) {
            System.out.println(resultado.get());
            resultado.get().descansar();
            System.out.println("El animal esta descansando..");
            System.out.println(resultado.get());
        } else {
            System.out.println("El animal no existe");
        }
    }

    private static void descansarAnimales(Set<Animales> listAnimals){
        listAnimals.forEach(System.out::println);
        listAnimals.forEach(Animales::descansar);
        System.out.println("Los Animales estan descansando");
        listAnimals.forEach(System.out::println);
    }

}
