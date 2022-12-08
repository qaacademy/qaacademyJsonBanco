package json;


import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ManipulandoJson {
    public String criandoJson(){
        JSONObject json = new JSONObject();
        json.put("nome","Silas");
        json.put("sobrenome", "Leao");
        json.put("idade", 23);
        //System.out.println(json);
        //System.out.println(json.get("nome"));
        return json.get("nome").toString();
    }

    public void navegarJsonArquivo(){
        JSONObject json;
        try{
            InputStream inputStream = new FileInputStream("./src/main/resources/arquivosJson/cep.json");
            json = new JSONObject(new JSONTokener(inputStream));
            System.out.println( json.get("logradouro"));
            System.out.println( json.get("cep"));
            System.out.println( json.get("complemento"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro ao converter arquivo json" + e);
        }
    }
}
