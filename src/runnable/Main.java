package runnable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import transportation.*;

public class Main {

	public static void main(String[] args) {
		runSimulation("data/dests.txt", "data/waggons.txt", "data/locs.txt", "data/missions.txt", "data/result.txt");
	}

	public static void runSimulation(String destsFileName, String waggonsFileName, 
			String locsFileName, String missionsFileName, String outputFileName) {
		// your code goes below	
		LinkedList<City> cities = new LinkedList<>();
		LinkedList<Mission> missions = new LinkedList<>();
		createCities(destsFileName, cities);
		createWaggons(waggonsFileName, cities);
		createLocomotives(locsFileName, cities);
		createMissions(missionsFileName, missions);
		for(Mission mission : missions){
			if(!mission.startMission()){
				// TODO: write error message
			}
			if(!mission.goMidwayCity()){
				// TODO: write error message
			}
			if(!mission.goTargetCity()){
				// TODO: write error message
			}
		}
		writeResult(outputFileName, cities);
	}

	private static void showErrorDialog(String errorText){
		JFrame frame = new JFrame("TrainTransportation");
		JOptionPane.showMessageDialog(frame, errorText, "Alert", JOptionPane.ERROR_MESSAGE);
		System.exit(1);
	}

	// TODO: write create functions
	private static void createCities(String fileName, LinkedList<City> cities){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while(line!=null){
				City c = new City(line);
				cities.add(c);
			}
		}catch(FileNotFoundException e1){
			
		}catch(IOException e2){

		}
	}

	private static void createWaggons(String fileName, LinkedList<City> cities){

	}

	private static void createLocomotives(String fileName, LinkedList<City> cities){

	}

	private static void createMissions(String fileName, LinkedList<Mission> missions){

	}

	private static void readAndCreateObjects(String destsFileName, String waggonsFileName, 
	String locsFileName, String missionsFileName, LinkedList<City> cities, LinkedList<Mission> missions){
		BufferedReader destReader, waggonsReader, locsReader, missionsReader;
		try{
			destReader = new BufferedReader(new FileReader(destsFileName));
			waggonsReader = new BufferedReader(new FileReader(waggonsFileName));
			locsReader = new BufferedReader(new FileReader(locsFileName));
			missionsReader = new BufferedReader(new FileReader(missionsFileName));
		}catch(FileNotFoundException e){

		}
	}

	private static void writeResult(String outputFileName, LinkedList<City> cities){
		BufferedWriter outputWriter;

	}


}
