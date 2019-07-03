package transportation;

import adts.MyDLL;

public class Train{

    private Locomotive locomotive;
    private MyDLL<Waggon> waggons = new MyDLL<>();

    public Train(){
    }

    public void setLocomotive(Locomotive l){
        locomotive = l;
    }

    public void addWaggon(Waggon w){
        waggons.add(w);
    }

    public Locomotive removeLocomotive(){
        Locomotive l = locomotive;
        locomotive = null;
        return l;
    }

    public Waggon removeWaggon(int index){
        if(index >= waggons.getSize()){
            return null;
        }
        Waggon w = waggons.remove(index);
        return w;
    }

}