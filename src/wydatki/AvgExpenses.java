package wydatki;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import poslowie.CreateMembersList;

public class AvgExpenses {
	private Map<String,String> members = new HashMap<String,String>();
	private int cadency;
	private double avg=0.0;
	private int i=0;
	AllExpenses posel=new AllExpenses();
	
	public AvgExpenses(int cadency){
		this.cadency=cadency;
	}
	
	public double AverageExpenses() throws IOException{
			CreateMembersList mep=new CreateMembersList(cadency);
			members=mep.createMap();
			for (Map.Entry<String, String> entry : members.entrySet()){
				i++;
				avg+=posel.AllExp(entry.getValue());
			}
	return avg/i;
	}
}
