package transportation;

import adts.MyDLL;

import java.util.Comparator;
import java.util.LinkedList;

public class Mission {

    int missionNo;
    City starting, midway, target;
    int fromStarting, fromMidway;
	LinkedList<Integer> indexes = new LinkedList<>();
    Train train = new Train();

    public Mission(int i){
        missionNo = i;
    }

	public boolean parseMissionString(String line, LinkedList<City> cities){
        String[] splitted = line.split("-");
        if(splitted.length != 6){
            return false;
        }
        try{
            for(City c : cities) {
                if (c.getName().equals(splitted[0])) {
                    starting = c;
                }
                else if(c.getName().equals(splitted[1])){
                    midway = c;
                }
                else if(c.getName().equals(splitted[2])){
                    target = c;
                }
            }
            fromStarting = Integer.parseInt(splitted[3]);
            fromMidway = Integer.parseInt(splitted[4]);
            String[] splittedIndexes = splitted[5].split(",");
            for(String s : splittedIndexes){
                indexes.add(Integer.parseInt(s));
            }
        }catch(NumberFormatException e){
            return false;
        }
		return true;
    }

    public String startMission(){
        Locomotive l = starting.popLocomotive();
        if(l == null){
            return "Mission "+Integer.toString(missionNo)+"- Starting city:"+starting+" doesn't have any locomotive.\nCan't start mission.\nSystem exiting.";
        }
        train.setLocomotive(l);
        for(int i=0; i<fromStarting; i++){
            Waggon w = starting.popWaggon();
            if(w==null){
                return "Mission "+Integer.toString(missionNo)+"- Starting city:"+starting+" doesn't have enough waggons.\nCan't start mission.\nSystem exiting.";
            }
            train.addWaggon(w);
        }
        return null;
    }

    public String goMidwayCity(){
        for(int i=0; i<fromMidway; i++){
            Waggon w = midway.popWaggon();
            if(w==null){
                return "Mission "+Integer.toString(missionNo)+"- Midway city:"+midway+" doesn't have enough waggon.\nCan't continue mission.\nSystem exiting.";
            }
            train.addWaggon(w);
        }
        for(Integer index : indexes){
            Waggon w = train.getWaggon(index);
            if(w==null){
                return "Mission "+Integer.toString(missionNo)+"- Train doesn't have any waggon at specified indexes.\nCan't continue mission.\nSystem exiting.";
            }
            midway.pushWaggon(w);
        }
        indexes.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for(Integer index : indexes){
            train.removeWaggon(index);
        }
        return null;
    }

    public String goTargetCity(){
        target.offerLocomotive(train.removeLocomotive());
        while(true){
            Waggon w = train.removeWaggon(0);
            if(w == null){
                break;
            }
            target.pushWaggon(w);
        }
        return null;
    }
    
}