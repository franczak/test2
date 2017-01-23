package poslowie;

public class Sejmometr {

	public static void main(String[] args) throws Exception{
		try{
		OptionParser parser = new OptionParser(args);
		parser.parseOptions();
		parser.run();
	}catch(Exception e){
		System.err.println(e.getMessage());
	}
	}
}
