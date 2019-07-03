package transportation;

import java.util.LinkedList;

public class Mission {

    City starting, midway, target;
    int fromStarting, fromMidway;
	LinkedList<Integer> indexes = new LinkedList<>();
    Train train = new Train();

	// TODO: write this function
	public boolean parseMissionString(String mission, LinkedList<City> cities){
		return true;
    }

    public boolean startMission(){
        Locomotive l = starting.popLocomotive();
        if(l == null){
            return false;
        }
        train.setLocomotive(l);
        for(int i=0; i<fromStarting; i++){
            Waggon w = starting.popWaggon();
            if(w==null){
                return false;
            }
            train.addWaggon(w);
        }
        return true;
    }

    public boolean goMidwayCity(){
        for(int i=0; i<fromMidway; i++){
            Waggon w = midway.popWaggon();
            if(w==null){
                return false;
            }
            train.addWaggon(w);
        }

        for(Integer index : indexes){
            Waggon w = train.removeWaggon(index);
            if(w==null){
                return false;
            }
            midway.pushWaggon(w);
        }
        return true;
    }

    public boolean goTargetCity(){
        target.offerLocomotive(train.removeLocomotive());
        while(true){
            Waggon w = train.removeWaggon(0);
            if(w == null){
                break;
            }
            target.pushWaggon(w);
        }
        return true;
    }
    
}