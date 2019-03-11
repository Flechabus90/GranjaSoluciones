package Granja;


import Granja.Archivo.Archivo;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class archivoTest {
    private File animalesFile = new File("src/test/Animales.txt");

    @Before
    public void setUp() {
        FileUtils.deleteQuietly(animalesFile);

    }

    @After
    public void tearDown() {
        FileUtils.deleteQuietly(animalesFile);
        System.out.println("Eliminado");
    }

    @Test
    public void testCargarAnimales() throws IOException {
        String dataFile = "Claudio/gallina/0/100\nMilka/vaca/0/100\nLucero/caballo/0/100";
        FileUtils.write(animalesFile,dataFile,"UTF-8");
        Archivo a = new Archivo("src/test/Animales.txt");
        Assert.assertEquals(3,a.cargarAnimales().size());
    }


}
