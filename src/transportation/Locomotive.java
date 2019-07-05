package transportation;

public class Locomotive extends Waggon implements Comparable<Locomotive>{

    private double power;

    public Locomotive(){
        super();
        power = 0;
    }

    public Locomotive(String n, double p){
        super(n);
        power = p;
    }

    public int compareTo(Locomotive loc){
        if(power > loc.power){
            return 1;
        }
        else if(power == loc.power){
            return 0;
        }
        return -1;
    }

    
}