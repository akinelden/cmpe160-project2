package transportation;

import adts.MyPQ;
import adts.MyStack;

public class City{

    private String name;

    private MyPQ<Locomotive> locomotiveGarage = new MyPQ<>();
    private MyStack<Waggon> waggonGarage = new MyStack<>();

    public City(){
        name = "";
    }

    public City(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public boolean offerLocomotive(Locomotive l){
        return locomotiveGarage.offer(l);
    }

    public void pushWaggon(Waggon w){
        waggonGarage.push(w);
    }

    public Locomotive popLocomotive(){
        return locomotiveGarage.poll();
    }

    public Waggon popWaggon(){
        return waggonGarage.pop();
    }
    
}