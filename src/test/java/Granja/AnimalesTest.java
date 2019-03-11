package Granja;

import Granja.clases.Animales;
import Granja.clases.TiposAnimales;
import Granja.interfaces.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalesTest {
    private Animales gallina;
    private Animales vaca;
    private Animales caballo;

    @Before
    public void setUp() {
        this.gallina = new Animales("Claudio", TiposAnimales.gallina);
        this.vaca = new Animales("Milka", TiposAnimales.vaca);
        this.caballo = new Animales("Lucero", TiposAnimales.caballo);
    }

    @Test
    public void testJugar() {
        gallina.jugar();
        vaca.jugar();
        caballo.jugar();
        Assert.assertNotEquals(100, gallina.getEnergia());
        Assert.assertEquals(85, vaca.getEnergia());
        Assert.assertEquals(88, caballo.getEnergia());

        Assert.assertEquals(20, gallina.getNivelHambre());
        Assert.assertEquals(20, vaca.getNivelHambre());
        Assert.assertEquals(33, caballo.getNivelHambre());
    }

    @Test
    public void testDescansarGallina() {
        gallina.setEnergia(60);
        gallina.setNivelHambre(50);
        gallina.descansar();
        Assert.assertEquals(85, gallina.getNivelHambre());
        Assert.assertEquals(100, gallina.getEnergia());
    }

    @Test
    public void testDefualtEnergiaHambre() {
        Assert.assertEquals(100, vaca.getEnergia());
        Assert.assertEquals(0, vaca.getNivelHambre());

    }

    @Test
    public void testAliementar(){
        gallina.setNivelHambre(30);
        vaca.setNivelHambre(23);
        caballo.setNivelHambre(40);

        gallina.alimentar();
        vaca.alimentar();
        caballo.alimentar();

        Assert.assertEquals(0, gallina.getNivelHambre());
        Assert.assertEquals(0, vaca.getNivelHambre());
        Assert.assertEquals(0, caballo.getNivelHambre());
    }

}
