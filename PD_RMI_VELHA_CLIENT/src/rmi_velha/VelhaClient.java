package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VelhaClient extends UnicastRemoteObject implements VelhaClientInterface{
	volatile private int tab[][] = new int [3][3];
	
	protected VelhaClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void PrintBoard(int[][] board) throws RemoteException {
		tab = board;
		
	}

	@Override
	public void Jogada() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
