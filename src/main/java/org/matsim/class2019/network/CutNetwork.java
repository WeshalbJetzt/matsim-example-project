package org.matsim.class2019.network;



import java.nio.file.Paths;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Network;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.network.io.NetworkWriter;
import org.matsim.core.router.util.LeastCostPathCalculator.Path;

public class CutNetwork {
	public static void main(String[] args) {
		

		Path inputNetwork= (Path) Paths.get("C:\\Users\\Friedemann\\Desktop\\MastSim Übung\\UE4\\erfurt-network.xml");
		Path outputNetwork= (Path) Paths.get("C:\\Users\\Friedemann\\Desktop\\MastSim Übung\\UE4\\erfurt-network_angepasst.xml");
		
		Network network= NetworkUtils.createNetwork();
		new MatsimNetworkReader(network).readFile(inputNetwork.toString());
		
		network.getLinks().get(Id.createLinkId("16578")).setCapacity(0);
		network.getLinks().get(Id.createLinkId("16584")).setCapacity(0);
		
		new NetworkWriter(network).write(outputNetwork.toString());;
	}
}
