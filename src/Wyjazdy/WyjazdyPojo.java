package Wyjazdy;

import com.google.gson.annotations.SerializedName;

import poslowie.Data;

public class WyjazdyPojo {
	    @SerializedName("layers")
	    private Departures departures;

	    private Data data;
	    public Data getData(){
	        return data;
	    }
	    public void setData(Data data){
	        this.data = data;
	    }
	    public Departures getDepartures ()
	    {
	        return departures;
	    }

	    public void setDepartures(Departures layers)
	    {
	        this.departures = layers;
	    }

	}
