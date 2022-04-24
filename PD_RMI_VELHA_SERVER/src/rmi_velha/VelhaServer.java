package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VelhaServer extends UnicastRemoteObject implements VelhaServerInterface {
	
	private volatile List<VelhaClientInterface> clients = new ArrayList<VelhaClientInterface>();
	volatile int board[][] = new int[3][3];
	public VelhaServerInterface isso = (VelhaServerInterface) this;
	
	protected VelhaServer() throws RemoteException {
		super();
		new RodarJogo().start();
	}

	@Override
	public void RegisterClient(VelhaClientInterface client) throws RemoteException {
		if(clients.size() < 2) {
			clients.add(client);
			System.out.println("Novo jogador registrado com sucesso! Total: "+clients.size());
		}
	}

	private class RodarJogo extends Thread {
		public void run() {
			for(;;) {
				if(clients.size()==2) {
					InicializaBoard();
					for(int i = 0; i < 9; i++) {
						System.out.println("Essa é a jogada: " + (i+1));
						if(i%2 == 0) { // Jogador 1
							
							try {
								clients.get(0).PrintBoard(board, 1, isso);
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						}else { // Jogador 2
							
							try {
								clients.get(1).PrintBoard(board, 2, isso);
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					break;
				}
			}
		}
	}
	
	private void InicializaBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public void SetBoard(int[][] tab) {
		board = tab;
	}
	
}
