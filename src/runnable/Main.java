package runnable;

import java.io.*;
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
		createMissions(missionsFileName, missions, cities);
		for(Mission mission : missions){
			String result;
			result = mission.startMission();
			showErrorDialog(result);
			result = mission.goMidwayCity();
			showErrorDialog(result);
			result = mission.goTargetCity();
			showErrorDialog(result);
		}
		writeResult(outputFileName, cities);
		showErrorDialog("Simulation is succesfully completed.\n Check the file named: '"+outputFileName+"' to see the results.");
	}


	private static void showErrorDialog(String errorText){
		if(errorText == null){
			return;
		}
		JFrame frame = new JFrame("TrainTransportation");
		JOptionPane.showMessageDialog(frame, errorText, "Alert", JOptionPane.ERROR_MESSAGE);
		System.exit(1);
	}


	private static void createCities(String fileName, LinkedList<City> cities){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while(line!=null){
				City c = new City(line);
				cities.add(c);
				line = reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e1){
			showErrorDialog("The file: " + fileName +" could not found.\nSystem exiting.");
		}catch(IOException e2){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nSystem exiting.");
		}
	}

	private static void createWaggons(String fileName, LinkedList<City> cities){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while(line!=null){
				String[] splitted = line.split("\\s");
				Waggon w = new Waggon(splitted[0]);
				for(City c : cities){
					if(c.getName().equals(splitted[1])){
						c.pushWaggon(w);
						break;
					}
				}
				line = reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e1){
			showErrorDialog("The file: " + fileName +" could not found.\nSystem exiting.");
		}catch(IOException e2){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nSystem exiting.");
		}catch(ArrayIndexOutOfBoundsException e3){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nOne more lines don't contain waggon name and/or city name.\nSystem exiting.");
		}
	}

	private static void createLocomotives(String fileName, LinkedList<City> cities){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while(line!=null){
				String[] splitted = line.split("\\s");
				Locomotive l = new Locomotive(splitted[0],Double.parseDouble(splitted[2]));
				for(City c : cities){
					if(c.getName().equals(splitted[1])){
						c.offerLocomotive(l);
						break;
					}
				}
				line = reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e1){
			showErrorDialog("The file: " + fileName +" could not found.\nSystem exiting.");
		}catch(IOException e2){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nSystem exiting.");
		}catch(ArrayIndexOutOfBoundsException e3){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nOne more lines don't contain locomotive name, city name and/or locomotive power.\nSystem exiting.");
		}catch(NumberFormatException e4){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nLocomotive power values are not double compatible.\nSystem exiting.");
		}
	}

	private static void createMissions(String fileName, LinkedList<Mission> missions, LinkedList<City> cities){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int i=1;
			while(line!=null){
				Mission m = new Mission(i);
				if(!m.parseMissionString(line, cities)){
					showErrorDialog("An error occurred while reading the file: "+fileName+".\nMissions are not properly defined.");
				}
				missions.add(m);
				i++;
				line = reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e1){
			showErrorDialog("The file: " + fileName +" could not found.\nSystem exiting.");
		}catch(IOException e2){
			showErrorDialog("An error occurred while reading " + fileName +" file.\nSystem exiting.");
		}
	}

	private static void writeResult(String outputFileName, LinkedList<City> cities){
		BufferedWriter writer;
		try{
			writer = new BufferedWriter(new FileWriter(outputFileName));
			for(City c : cities){
				writer.write(c.getName()+"\n");
				writer.write("Waggon Garage:\n");
				Waggon w = c.popWaggon();
				while(w!=null){
					writer.write(w.getName()+"\n");
					w = c.popWaggon();
				}
				writer.write("Locomotive Garage:\n");
				Locomotive l = c.popLocomotive();
				while(l!=null){
					writer.write(l.getName()+"\n");
					l = c.popLocomotive();
				}
				writer.write("-------------\n");
			}
			writer.close();
		}catch (IOException e){
			showErrorDialog("An error occurred while writing the output file.\nPlease try again.");
		}

	}


}
