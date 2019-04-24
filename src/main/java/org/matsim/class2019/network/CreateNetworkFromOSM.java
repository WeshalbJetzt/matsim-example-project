package org.matsim.class2019.network;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.matsim.api.core.v01.network.Network;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.algorithms.NetworkCleaner;
import org.matsim.core.network.io.NetworkWriter;
import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.core.utils.io.OsmNetworkReader;

public class CreateNetworkFromOSM {
	
	private static Path inputFile = Paths.get("C:\\Users\\Friedemann\\Desktop\\MastSim Übung\\UE3\\Download\\thueringen-latest.osm\\thueringen-latest.osm");
	private static String epsg = "EPSG:25832";
	
	public static void main(String[] args) {
		new CreateNetworkFromOSM().create();
	}
	
	public void create() {
		
		//create empty network
		Network network = NetworkUtils.createNetwork();
		
		//coordinate transformation
		CoordinateTransformation transformation = TransformationFactory.getCoordinateTransformation(
				TransformationFactory.WGS84, epsg);
		
		OsmNetworkReader reader = new OsmNetworkReader(network, transformation, true, true);
		
		reader.addOsmFilter((coord, hierachy) -> {
			return hierachy <= 4; //Entscheidung ob Hauptstraßen oder Nebenstraßen etc...
		});
		
		reader.parse(inputFile.toString());
		
		new NetworkCleaner().run(network);
		
		new NetworkWriter(network).write(Paths.get("C:\\Users\\Friedemann\\Desktop\\MastSim Übung\\UE3\\Download\\Network\\test-network.xml.gz").toString());
		
		
	}
	
	
}
