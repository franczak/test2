package Wyjazdy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import poslowie.CreateMembersList;

public class MostExpensiveTravel {
	private Map<String,String> members = new HashMap<String,String>();
	private TravelCost travel;
	private double tmp=0.0;
	public double max = 0.0;
	public String name;
	
	public MostExpensiveTravel(){
	}
	
	public String FindMostExpensive(int cadency) throws IOException{
		CreateMembersList mep=new CreateMembersList(cadency);
		members=mep.createMap();
		for (Map.Entry<String, String> entry : members.entrySet()){
				travel=new TravelCost();
				tmp=travel.FindMaxCost(entry.getValue());
				if(tmp>max){
					max=tmp;
					name=entry.getKey();
			}
		}
	return name;	
	}
}
	

