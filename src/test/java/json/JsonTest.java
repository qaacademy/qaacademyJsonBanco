package json;

import org.junit.Assert;
import org.junit.Test;

public class JsonTest {

    @Test
    public void testCriandojson(){
        ManipulandoJson manipulandoJson = new ManipulandoJson();
        String valor = manipulandoJson.criandoJson();
        Assert.assertEquals("Silas", valor);
    }
    @Test
    public void lerJson(){
        ManipulandoJson manipulandoJson = new ManipulandoJson();
        manipulandoJson.navegarJsonArquivo();
    }
}
