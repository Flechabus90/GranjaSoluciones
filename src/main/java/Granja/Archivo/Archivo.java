package Granja.Archivo;

import Granja.clases.Animales;
import Granja.clases.TiposAnimales;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicoh
 */
public class Archivo {

    private File file;

    public Archivo(String nombreArchivo) {
        this.file = new File(nombreArchivo);
    }

    private void agregarAnimal(Animales nueva) {
        try {
            FileWriter fw;
            BufferedWriter bw;

            fw = new FileWriter(this.file, true);
            bw = new BufferedWriter(fw);
            bw.write(nueva.getNombre() + "/" + nueva.getTipo() + "/" + nueva.getNivelHambre() + "/" + nueva.getEnergia());
            bw.newLine();
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Jugarda informacion en un TxT parseado por "/"
     *
     * @return lista de animales
     */
    public Set<Animales> cargarAnimales() {
        Set<Animales> listaAnimalles = new HashSet<>();
        try {
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] contacto = linea.split("/");
                Animales g = new Animales(contacto[0], TiposAnimales.valueOf(contacto[1]));
                g.setNivelHambre(Integer.valueOf(contacto[2]));
                g.setEnergia(Integer.valueOf(contacto[3]));
                listaAnimalles.add(g);
            }
            System.out.println("Datos cargados correctamente");
            System.out.println("Total de animales cargados: " + listaAnimalles.size());
            return listaAnimalles;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAnimalles;

    }

    private void vaciarArchivo() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.file));
        bw.write("");
        bw.close();
    }



    public void save(Set<Animales> listAnimalls) throws IOException {
        vaciarArchivo();
        listAnimalls.forEach(this::agregarAnimal);
        System.out.printf("Animales guardados:\n");
        listAnimalls.forEach(System.out::println);
    }

}
