package rmi_velha;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		VelhaServerInterface server = (VelhaServerInterface) 
				Naming.lookup("rmi://127.0.0.1:1098/VelhaServerCallback");

		VelhaClientInterface client = new VelhaClient();
		
		//server.registerClient(client);
	}

}