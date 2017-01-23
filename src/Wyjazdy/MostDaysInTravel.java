package Wyjazdy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import poslowie.CreateMembersList;

public class MostDaysInTravel {
	private String name;
	private int max=0;
	private int z=0;
	private Map<String,String> members = new HashMap<String,String>();
	private DaysInTravel pro;
	public MostDaysInTravel(){
		
	}
	
	public String FindName(int cadency) throws IOException{
		CreateMembersList mep=new CreateMembersList(cadency);
		members=mep.createMap();
		for (Map.Entry<String, String> entry : members.entrySet()){
				pro=new DaysInTravel();
				z=0;
				z=pro.DaysInTrv(entry.getValue());
				if(z>max){
					max=z;
					name=entry.getKey();
			}
		}
		return name;
	}
}
