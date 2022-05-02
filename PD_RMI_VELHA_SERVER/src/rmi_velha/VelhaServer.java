package rmi_velha;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class VelhaServer extends UnicastRemoteObject implements VelhaServerInterface {
	
	private volatile List<VelhaClientInterface> clients = new ArrayList<VelhaClientInterface>();
	volatile int board[][] = new int[3][3];
	public VelhaServerInterface isso = (VelhaServerInterface) this;
	private boolean Winner[] = new boolean[2];
	
	protected VelhaServer() throws RemoteException {
		super();
		Winner[0] = false;
		Winner[1] = false;
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
					int i;
					for(i = 0; i < 9; i++) { // i < 9 garante que não vai ter mais jogadas que o necessário.
						System.out.println("Essa é a jogada: " + (i+1));
						if(i%2 == 0) { // Jogador 1
							
							try {
								clients.get(0).PrintBoard(board, 1, isso);
							} catch (RemoteException e) {
								e.printStackTrace();
							}
							
							if(Winner[0]) {
								// Printa nos clients quem ganhou.
								try {
									clients.get(0).PrintWin(1, board);
								} catch (RemoteException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								try {
									clients.get(1).PrintWin(1, board);
								} catch (RemoteException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								break;
							}
							
						}else { // Jogador 2
							try {
								clients.get(1).PrintBoard(board, 2, isso);
							} catch (RemoteException e) {
								e.printStackTrace();
							}
							
							if(Winner[1]) {
								// Printa nos clients quem ganhou.
								try {
									clients.get(0).PrintWin(2, board);
								} catch (RemoteException e) {
									e.printStackTrace();
								}
								
								try {
									clients.get(1).PrintWin(2, board);
								} catch (RemoteException e) {
									e.printStackTrace();
								}
								break;
							}
							
						}
					}
					if (i == 9) {
						try {
							clients.get(0).PrintVelha(board);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
						try {
							clients.get(1).PrintVelha(board);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
	
	// Inicializa o tabuleiro
	private void InicializaBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	// Atualiza o tabuleiro
	public void SetBoard(int[][] tab) {
		board = tab;
	}
	// Seta o ganhador.
	public void SetWinner(int jogador) {
		Winner[jogador - 1] = true;
	}
	
}
