package transportation;

public class Waggon{

    private String name;
    private String location;

    public Waggon(){
        name = "";
        location = "";
    }

    public Waggon(String n, String l){
        name = n;
        location = l;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String l){
        location = l;
    }

    
}