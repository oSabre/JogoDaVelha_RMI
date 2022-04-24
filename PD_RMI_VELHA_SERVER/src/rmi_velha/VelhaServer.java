package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VelhaServer extends UnicastRemoteObject implements VelhaServerInterface {
	
	private volatile List<VelhaClientInterface> clients = new ArrayList<VelhaClientInterface>();
	volatile int board[][] = new int[3][3];
	
	protected VelhaServer() throws RemoteException {
		super();
		RodarJogo();
	}

	@Override
	public void RegisterClient(VelhaClientInterface client) throws RemoteException {
		if(clients.size() < 2) {
			clients.add(client);
			System.out.println("Novo jogador registrado com sucesso! Total: "+clients.size());
		}
	}

	private void RodarJogo() {
		for(;;) {
			if(clients.size()==2) {
				InicializaBoard();
				for(int i = 0; i < 9; i++) {
					System.out.println("Essa é a jogada: " + i);
					if(i%2 == 0) { // Jogador 1
						
					}else { // Jogador 2
						
					}
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
	
}
