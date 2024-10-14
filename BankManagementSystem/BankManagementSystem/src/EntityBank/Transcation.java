package EntityBank;

public class Transcation {
	    private String type;
	    private double amount;

	    public Transcation(String type, double amount) {
	    	this.type = type;
	        this.amount = amount;
		}

	    @Override
	    public String toString() {
	        return type + ": $" + amount;
	    }
	}
