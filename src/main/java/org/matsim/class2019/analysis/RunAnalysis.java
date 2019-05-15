package org.matsim.class2019.analysis;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.MatsimEventsReader;


public class RunAnalysis {
	public static void main(String[] args) {
		Path events = Paths.get("C:\\Users\\Friedemann\\Desktop\\MastSim Übung\\UE5\\policyCase\\output_events.xml.gz");
		
		TravelTimeEventHandler handler = new TravelTimeEventHandler();
		EventsManager manager = EventsUtils.createEventsManager();
		manager.addHandler(new TravelTimeEventHandler());
		
		new MatsimEventsReader(manager).readFile(events.toString());
		
		double totalTravelTime = handler.computeOverallTravelTime();
		
		System.out.println("Die TravelTime ist: " + totalTravelTime);
	}
}
