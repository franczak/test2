package Wyjazdy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import poslowie.CreateMembersList;

public class ItalyVisitors {
	private Map<String,String> members = new HashMap<String,String>();
	private URL link;
	
	public ItalyVisitors(){
		
	}
	
	public void FindVisitors(int cadency) throws IOException{
		CreateMembersList mep=new CreateMembersList(cadency);
		members=mep.createMap();
		for (Map.Entry<String, String> entry : members.entrySet()){
				if(SetName(entry.getValue())){
					System.out.println(entry.getKey());
				}
			}

		}

	private boolean SetName(String id) throws IOException{
		link = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/"+id+".json?layers[]=krs&layers[]=wyjazdy");
		Gson json = new Gson();
		WyjazdyPojo pojo;
		 try {
		pojo = json.fromJson(new JsonReader(new InputStreamReader(link.openStream())), WyjazdyPojo.class);
		if(HasBeen(pojo))
			return true;
		else return false;
		 }
		 catch(Exception e){
			 return false;
		 }

}

	
	private boolean HasBeen(WyjazdyPojo pojo){
		for(Wyjazdy dep : pojo.getDepartures().getWyjazdy()){
			if(dep.getKraj().equals("W³ochy")){
				return true;
			}
		}
		return false;
	}
}
