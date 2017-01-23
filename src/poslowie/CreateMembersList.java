package poslowie;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CreateMembersList {
	private MyPojo json;
    private Map<String, String> nameMap = new HashMap<String, String>();
    private int cadency;
    
    public CreateMembersList(int cadency){
    	this.cadency=cadency;
    }

    public Map<String,String> createMap() throws IOException {
        String link = "https:\\//api-v3.mojepanstwo.pl\\/dane\\/poslowie.json?conditions[poslowie.kadencja]="+Integer.toString(cadency);
        createObject(link);
        while(json.getLinks().getNext()!=null) {
            addJsonToMap(nameMap);
            createObject(json.getLinks().getNext());
        }
        addJsonToMap(nameMap);
        return nameMap;
}
    private void createObject(String link) throws IOException {
        URL url = new URL(fixLink(link));
        Gson gson = new Gson();
        json = gson.fromJson(new JsonReader(new InputStreamReader(url.openStream())), MyPojo.class);
}
    private void addJsonToMap(Map<String, String> map) {
        for (int i = 0; i < json.getDataobject().length; i++) {
            map.put(json.getDataobject()[i].getData().getNazwa(), json.getDataobject()[i].getId());
        }
    }
    private String fixLink(String link){
        String fixed = link.replace("\\/", "/");
        return fixed;
    }
    
}


    
