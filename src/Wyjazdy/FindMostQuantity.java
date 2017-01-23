package Wyjazdy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import poslowie.CreateMembersList;

public class FindMostQuantity {
	private String name;
	private int max=0;
	private int z=0;
	private Map<String,String> meps = new HashMap<String,String>();
	QuantityDep dep;
	
	public String FindName(int cadency) throws IOException{
			CreateMembersList mep=new CreateMembersList(cadency);
			meps=mep.createMap();
			for (Map.Entry<String, String> entry : meps.entrySet()){
				dep=new QuantityDep();
				z=0;
				z=dep.CountDep(Integer.parseInt(entry.getValue()));
				if(z>max){
					max=z;
					name=entry.getKey();
			}
			}
		return name;
	
	
	}
}
