package rmi_velha;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VelhaServerInterface extends Remote{
	
	public void RegisterClient(VelhaClientInterface client) throws RemoteException;
	
}
