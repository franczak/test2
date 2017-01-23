package poslowie;

import Wyjazdy.FindMostQuantity;
import Wyjazdy.ItalyVisitors;
import Wyjazdy.MostDaysInTravel;
import Wyjazdy.MostExpensiveTravel;
import wydatki.AllExpenses;
import wydatki.AvgExpenses;
import wydatki.IncidentalExpenses;

public class OptionParser {
	private String[] args;
	private int cadency;
	private String firstname;
	private String lastname;
	private String name;
	private boolean all=false;
	private boolean avg=false;
	private boolean small=false;
	private boolean italy=false;
	private boolean mostexpensive=false;
	private boolean mostdays=false;
	private boolean quantity=false;
	
	public OptionParser(String[] args) throws Exception{
		this.args=args;
		if(args.length==0)
			throw new Exception("You didn't enter options\nCheck -h");
	}
	
	
	
	
	
	public void parseOptions() throws Exception{
		for(int i=0; i<args.length;i++){
			if(args[i].equals("-n")){
				firstname=args[i+1];
				lastname=args[i+2];}
			if(args[i].equals("-c")){
				cadency=Integer.parseInt(args[i+1]);
				if(cadency!=7 && cadency!=8)
					throw new Exception("Wrong cadency!");}
			if(args[i].equals("-o")){
				if(args[i+1].equals("s")) {all=true;break;} else{
				if(args[i+1].equals("d")) {small=true;break;} else{
				if(args[i+1].equals("A")) {avg=true;break;} else{
				if(args[i+1].equals("nd")) {mostdays=true;break;} else{
				if(args[i+1].equals("me")) {mostexpensive=true;break;} else{
				if(args[i+1].equals("i")) {italy=true;break;} else{
				if(args[i+1].equals("mt")) {quantity=true;break;} else{
					throw new Exception("Wrong option!");}}}}}}
				}
			}
		}	
				
	/*			if(args[i].equals("-h")){
					System.out.println("Available options:");
					System.out.println("-c + enter a cadency");
					System.out.println("-n + enter firstname and lastname");
					System.out.println("-o + enter an option");
					System.out.println("s - total expenses of one member");
					System.out.println("d - incidental expenses");
					System.out.println("A - average spendings");
					System.out.println("nd - most days in travel");
					System.out.println("me - most expensive travel");
					System.out.println("i - Italy visitors");
					System.out.println("mt - most travels");
					break;
				}*/
	}
	
public void run() throws Exception{
				if(avg){
					AvgExpenses avg = new AvgExpenses(cadency);
					System.out.println("The average expenses of "+cadency+" cadency is "+avg.AverageExpenses());
				}
				if(mostdays){
					MostDaysInTravel most=new MostDaysInTravel();
					System.out.println(most.FindName(cadency) + " had the most days in travel in "+cadency+" cadency");
				}
				if(mostexpensive){
					MostExpensiveTravel travel=new MostExpensiveTravel();
					System.out.println(travel.FindMostExpensive(cadency)+" had the most expensive travel in "+cadency+" cadency");
				}
				if(italy){
					ItalyVisitors italy=new ItalyVisitors();
					System.out.println("Italy visitors in "+cadency+" cadency:");
					italy.FindVisitors(cadency);
				}
				if(quantity){
					FindMostQuantity find= new FindMostQuantity();
					System.out.println(find.FindName(cadency)+" had the most travels in "+cadency+" cadency");
				}
				if(all){
					AllExpenses all=new AllExpenses();
					try{
					FindId id=new FindId();
					name=id.IdFromName(firstname,lastname);
					}catch(Exception e){
						throw new Exception("Wrong name");
					}
					System.out.println("Sum of expenses of "+firstname+" "+lastname+": " +all.AllExp(name));
			
			}
			
			if(small){
				IncidentalExpenses exp=new IncidentalExpenses();
				try{
					FindId id=new FindId();
					name=id.IdFromName(firstname,lastname);
					}catch(Exception e){
						throw new Exception("Wrong name");
					}
				System.out.println("Incidental expenses of "+firstname+" "+lastname+": " +exp.InciExp(name));
			}
			}
	}
			
