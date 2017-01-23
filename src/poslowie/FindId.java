package poslowie;

import java.util.HashMap;
import java.util.Map;

public class FindId {
	private String name;
	private Map<String,String> members = new HashMap<String,String>();
	private boolean bool=false;
	public FindId(){
		
	}
	public String IdFromName(String firstName, String lastName) throws Exception{
			name=firstName+" "+lastName;
			CreateMembersList mep=new CreateMembersList(8);
			members=mep.createMap();
				for (Map.Entry<String, String> entry : members.entrySet()){
				if(name.equals(entry.getKey())){
					bool=true;
					return entry.getValue();
				}
				}
			if(!bool){
				mep=new CreateMembersList(7);
				members = mep.createMap();
				for (Map.Entry<String, String> entry : members.entrySet()){
				if(name.equals(entry.getKey())){
					return entry.getValue();
				
				}
				}
			}
			else{
				throw new Exception("Wrong name!");
			} return "";
}
}

