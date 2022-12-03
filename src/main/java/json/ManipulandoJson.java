package json;


import org.json.JSONObject;

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
}
