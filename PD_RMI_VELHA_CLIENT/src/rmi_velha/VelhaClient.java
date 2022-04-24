package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VelhaClient extends UnicastRemoteObject implements VelhaClientInterface{

	protected VelhaClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void PrintBoard(int[][] board) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Jogada() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
