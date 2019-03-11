/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Granja.clases;

import Granja.interfaces.Animal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Nicoh
 */
public class Animales implements Animal {

    private String nombre;
    private int nivelHambre;
    private int energia;
    private TiposAnimales tipo;


    public Animales(String nombre, TiposAnimales tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        valoresDefault();
    }


    @Override
    public void jugar() {

        if (tipo.equals(TiposAnimales.gallina)) {
            int randNum = getNumeroRandom(20, 50);

            //Puede salir negativo, solucion   if (this.getEnergia() >= randNum && this.getNivelHambre() < 40) {
            if (this.getEnergia() >= 20 && this.getNivelHambre() < 40) {
                this.setNivelHambre(this.getNivelHambre() + 20);
                this.setEnergia(this.getEnergia() - randNum);
            } else {
                System.out.println("No puedes jugar con la gallina");
                System.out.println("Energia Actual: " + this.getEnergia() + "\nHambre Actual: " + this.getNivelHambre());
                System.out.println("Necesario:");
                System.out.println("Energia mayor a: 20" + "\nHambre menor a: 40");
            }
            return;
        }

        if (tipo.equals(TiposAnimales.vaca)) {
            if (this.getEnergia() >= 30 && this.getNivelHambre() < 20) {
                this.setEnergia(this.getEnergia() - 15);
                this.setNivelHambre(this.getNivelHambre() + 20);
            }else{
                System.out.println("No puedes jugar con la vaca");
                System.out.println("Energia Actual: "+ this.getEnergia() + "\n Hambre Actual: "+ this.getNivelHambre());
                System.out.println("Necessario");
                System.out.println("Energia minima: 30" +"\nHambre menor a: 20");
            }
            return;
        }

        if (tipo.equals(TiposAnimales.caballo)) {
            if (this.getEnergia()>=50 && this.getNivelHambre()< 25 ) {
                this.setEnergia(this.getEnergia() - 12);
                this.setNivelHambre(this.getNivelHambre() + 33);
            } else {
                System.out.println("No se puede jugar con el caballo");
                System.out.println("Energia Actual: "+ this.getEnergia() + "\n Hambre Actual: "+ this.getNivelHambre());
                System.out.println("Necessario");
                System.out.println("Energia minima: 50" +"\nHambre menor a: 25");
            }
            return;
            }

          System.out.println("No se encontro el tipo de animal");
    }


    @Override
    public void descansar() {
        this.setEnergia(100);
        this.setNivelHambre(getNivelHambre() + 35);
    }

    /**
     * Baja nivel de hambre segun animal.
     */

    @Override
    public void alimentar() {

        if (tipo.equals(TiposAnimales.gallina)) {
            this.setNivelHambre(this.getNivelHambre() - 30);
        }

        if (tipo.equals(TiposAnimales.vaca)) {
            this.setNivelHambre(this.getNivelHambre() - 23);
        }

        if (tipo.equals(TiposAnimales.caballo)) {
            if (this.getNumeroRandom(0, 100) > 50) {
                this.setNivelHambre(this.getNivelHambre() - 40);
            } else {
                System.out.println("El caballo no quiere comer, intenta de nuevo");
            }
        }


    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelHambre() {
        return nivelHambre;
    }

    public void setNivelHambre(int nivelHambre) {
        this.nivelHambre = nivelHambre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int Energia) {
        this.energia = Energia;
    }

    /**
     * @param min valor minimo
     * @param max valor maximo
     * @return numero random
     * <p>
     * Recibe dos enteros y reotrna un numero random entre ambos.
     */

    private int getNumeroRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * Carga el nivel del hambre en 0 y la energia en 100
     */

    private void valoresDefault() {
        this.nivelHambre = 0;
        this.energia = 100;
    }

    public TiposAnimales getTipo() {
        return tipo;
    }

    public void setTipo(TiposAnimales tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "Nombre: '" + nombre + '\'' +
                ", H=" + nivelHambre +
                ", E=" + energia +
                ", Tipo=" + tipo;
    }
}
